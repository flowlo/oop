
public abstract class Autodrom extends Thread{
	protected int speed;
	protected GameField gamefield;	//spielfeld
	protected int posX;				
	protected int posY;
	protected direction dir;		//Fahrtrichtung
	private final char ID;			//mit dieser "ID" wird es in der toString methode von GameField dargestellt. es koennen auch mehrere das gleiche Zeichen haben
	
	private int points;				//AUF SYNC ACHTEN punkte (+1 pro rammen / -1 pro gerammt werden)
	
	public enum direction {north, east, south, west};
	
	/**
	 * Erstellt ein neues Autodrom und setzt die Startposition.
	 * Uebergeben werden das Spielfeld und die Startposition.
	 * Die Startposition muss sich auf dem Spielfeld befinden. Und eine dazu gueltige Richtung haben.
	 * Es gilt:
	 * 2<fieldWidth
	 * 2<fieldHeight
	 * startX<=fieldWidth
	 * startY<=fieldHeight
	 * 
	 * @param fieldWidth breite des Spielfeldes
	 * @param fieldHeight hoehe des Spielfeldes
	 * @param startX Startposition des Autos
	 * @param startY Startposition des Autos
	 * @param startDirection Richtung in welche das Auto sieht
	 */
	public Autodrom(GameField field, int startX, int startY, direction startDirection, char ID)
	{
		this.ID=ID;
		this.dir=startDirection;
		this.gamefield=field;
		points=0;
		this.posX=startX;
		this.posY=startY;
		gamefield.addCar(getPosX(), getPosY(), this);
	}
	
	public abstract void run();

	
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
		switch(dir)
		{
		case north:
			this.posY--;
			break;
		case east:
			this.posX++;
			break;
		case south:
			this.posY++;
			break;
		case west:
			this.posX--;
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
			this.posX--;
			this.posY--;
			this.dir=direction.west;
			break;
		case east:
			this.posX++;
			this.posY--;
			this.dir=direction.north;
			break;
		case south:
			this.posX++;
			this.posY++;
			this.dir=direction.east;
			break;
		case west:
			this.posX--;
			this.posY++;
			this.dir=direction.south;			
		}

	}
	
	
	/**
	 * Das Fahrzeug faehrt nach rechts (1 nach vorne, 1 nach rechts und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	protected void moveRight()
	{
		switch(dir)
		{
		case north:
			this.posX++;
			this.posY--;
			this.dir=direction.east;
			break;
		case east:
			this.posX++;
			this.posY++;
			this.dir=direction.south;
			break;
		case south:
			this.posX--;
			this.posY++;
			this.dir=direction.west;
			break;
		case west:
			this.posX--;
			this.posY--;
			this.dir=direction.north;
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


	public String toString()
	{
		return new String("Car with ID '"+this.ID+"' got "+this.points+" points.");
	}
	
}
