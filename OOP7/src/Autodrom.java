/**
 * die Methoden getPosX und getPosY muessen immer die aktuelle Position am Feld zurueck liefern um einen crash zu erkennen.
 * zur Berechnung der Zielposition gibt es daher tmpPosX und tmpPosY
 * 
 * @author Simon
 * 
 *         Zusicherungern:
 *         * Ein Autodrom befindet sich auf genau einem Feld im Spielfeld
 *         * Auf diesem Feld befindet sich kein anderes
 *         * Das Autodrom ist in eine der vier Himmelsrichtungen ausgerichtet
 *         * Ein Autodrom kann sich nur auf bestimmte Nachbarfelder bewegen, nie ein Feld ueberspringen
 *         * Bewegt es sich nach (schraeg) links/rechts, aendert sich dementsprechend die Ausrichtung
 *         * Wuerde es sich auf ein Feld bewegen, das bereits besetzt ist, rammt es ein anderes Auto, bleibt aber auf der derzeitigen Position. Ein
 *         Pluspunkt
 *         * Faehrt ein anderes Auto auf die Position dieses Autos wird es gerammt. Ein Minuspunkt.
 *         * Ein Autodrom bewegt sich nach einer bestimmten Zeit auf ein anderes Feld.
 *         * Erreicht ein Auto 10 Punkte, hat es gewonnen und das Spiel endet.
 */
public abstract class Autodrom extends Thread {
	private int speed;
	protected GameField gamefield;

	protected boolean frontalCrash;

	protected int tmpPosX;
	protected int tmpPosY;
	private Integer posX;
	private Integer posY;
	protected direction dir, tmpDir;
	private final char ID;

	private int moves;
	private int points;

	public enum direction {
		north, east, south, west
	};

	/**
	 * Erzeugt ein neues Autodrom. Es wird erwartet, dass fuer startX, startY und startDirection gueltige Parameter angegeben werden (in Bezug auf
	 * field), so dass eine Bewegung in Richtung startDirection
	 * auch eine guelitge Position ist.
	 * 
	 * @param field
	 *            Spielfeld
	 * @param startX
	 *            Position am Spielfeld
	 * @param startY
	 *            Position am Spielfeld
	 * @param startDirection
	 *            Fahrtrichtung des Autodroms
	 * @param speed
	 *            Wartezeit (in ms) zwischen zwei Bewegungen (nicht negativ)
	 * @param moves
	 *            Anzahl an Bewegungen (nicht negativ)
	 * @param ID
	 *            Zeichen, welche in der toString verwendet werden soll.
	 */
	public Autodrom(GameField field, int startX, int startY, direction startDirection, int speed, int moves, char ID)
	{
		this.moves = moves;
		this.speed = speed;
		this.ID = ID;
		this.dir = startDirection;
		this.gamefield = field;
		points = 0;
		this.posX = startX;
		this.posY = startY;
		gamefield.addCar(getPosX(), getPosY(), this);
	}

	@Override
	public void run() {
		try
		{
			while (!this.isInterrupted())
			{
				if (moves <= 0)
				{
					System.out.println("\nMaximalzahl an Zuegen erreicht.");
					gamefield.stopRace();
				}
				moves--;
				Thread.sleep(speed);

				tmpPosX = this.getPosX();
				tmpPosY = this.getPosY();
				tmpDir = this.dir;
				move();

				//Auch wenn laut Angabe schlecht wird gamefield hier gesperrt.
				//die Berechnung der Bewegung wird onehin vorher in move() erledigt.
				//gamefield bleibt also nur ueber einen minimalen Zeitraum gesperrt.
				synchronized (gamefield)
				{
					int res = gamefield.moveCar(posX, posY, tmpPosX, tmpPosY, tmpDir, this);
					if (res == 1) //normaler crash
					{
						addPoint();
						if (points >= 10)
							gamefield.stopRace();
					}
					else if (res == 2) //frontaler crash
					{
						System.out.println("frontaler crash");
						this.frontalCrash = true;
					}
					else if (res == 0)
					{
						posX = tmpPosX;
						posY = tmpPosY;
						dir = tmpDir;
					}
				}

			}
		} catch (InterruptedException e)
		{
			// Thread interrupted. Car stops.
		}
	}

	/**
	 * Implementierung der BewegungsLogik.
	 * Nach einem Aufruf von move muessen tmpPosX und tmpPosY eine gueltige Zielposition haben.
	 */
	protected abstract void move();

	public int getPoints()
	{
		return points;
	}

	public synchronized void addPoint()
	{
		points++;
	}

	public synchronized void crashed()
	{
		points--;
	}

	/**
	 * das Fahrzeug faehrt nach vorne. Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	protected void moveForward()
	{
		switch (dir)
		{
		case north:
			this.tmpPosY--;
			break;
		case east:
			this.tmpPosX++;
			break;
		case south:
			this.tmpPosY++;
			break;
		case west:
			this.tmpPosX--;
		}
	}

	/**
	 * Das Fahrzeug faehrt nach links (1 nach vorne, 1 nach links und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	protected void moveLeft()
	{
		switch (dir)
		{
		case north:
			this.tmpPosX--;
			this.tmpPosY--;
			this.tmpDir = direction.west;
			break;
		case east:
			this.tmpPosX++;
			this.tmpPosY--;
			this.tmpDir = direction.north;
			break;
		case south:
			this.tmpPosX++;
			this.tmpPosY++;
			this.tmpDir = direction.east;
			break;
		case west:
			this.tmpPosX--;
			this.tmpPosY++;
			this.tmpDir = direction.south;
		}

	}

	/**
	 * Das Fahrzeug faehrt nach rechts (1 nach vorne, 1 nach rechts und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	protected void moveRight()
	{
		switch (dir)
		{
		case north:
			this.tmpPosX++;
			this.tmpPosY--;
			this.tmpDir = direction.east;
			break;
		case east:
			this.tmpPosX++;
			this.tmpPosY++;
			this.tmpDir = direction.south;
			break;
		case south:
			this.tmpPosX--;
			this.tmpPosY++;
			this.tmpDir = direction.west;
			break;
		case west:
			this.tmpPosX--;
			this.tmpPosY--;
			this.tmpDir = direction.north;
		}
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @return the iD
	 */
	public char getID() {
		return ID;
	}

	public direction getDirection()
	{
		return this.dir;
	}

	@Override
	public String toString()
	{
		return new String("Car with ID '" + this.ID + "' got " + this.points + " points.");
	}

}
