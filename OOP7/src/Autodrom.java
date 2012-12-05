
public abstract class Autodrom extends Thread{
	private int speed;
	protected GameField gamefield;
	
	protected boolean frontalCrash;
	
	protected int tmpPosX;
	protected int tmpPosY;
	protected Integer posX;				
	protected Integer posY;
	protected direction dir, tmpDir;		
	private final char ID;		
	
	private int moves;
	private int points;				
	
	public enum direction {north, east, south, west};
	

	public Autodrom(GameField field, int startX, int startY, direction startDirection,int speed, int moves,char ID)
	{
		this.moves=moves;
		this.speed=speed;
		this.ID=ID;
		this.dir=startDirection;
		this.gamefield=field;
		points=0;
		this.posX=startX;
		this.posY=startY;
		gamefield.addCar(getPosX(), getPosY(), this);
	}
	
	@Override
	public void run() {
		try
		{		
		while(!this.isInterrupted())
		{
			if(moves<=0)
			{
				System.out.println("\nMaximalzahl an Zuegen erreicht.");
				gamefield.stopRace();
			}
			moves--;
			Thread.sleep(speed);
			
			
			
			tmpPosX=this.getPosX();
			tmpPosY=this.getPosY();
			tmpDir=this.dir;
			move();
			
			//Auch wenn laut Angabe schlecht wird gamefield hier gesperrt.
			//die Berechnung der Bewegung wird onehin vorher in move() erledigt.
			//gamefield bleibt also nur ueber einen minimalen Zeitraum gesperrt.
			synchronized(gamefield)
			{
				int res=gamefield.moveCar(posX, posY,tmpPosX,tmpPosY,tmpDir, this);
				if(res==1) //normaler crash
				{
					addPoint();
					if(points>=10) gamefield.stopRace();
				}
				else if(res==2) //frontaler crash
				{			
					System.out.println("frontaler crash");
					this.frontalCrash=true;
				}
				else if(res==0)
				{
					posX=tmpPosX;
					posY=tmpPosY;
					dir=tmpDir;
				}
			}
				
		}
		}
		catch(InterruptedException e)
		{
			//System.out.println("car interrupted");
		}
	}
	

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
		switch(dir)
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
			this.tmpDir=direction.west;
			break;
		case east:
			this.tmpPosX++;
			this.tmpPosY--;
			this.tmpDir=direction.north;
			break;
		case south:
			this.tmpPosX++;
			this.tmpPosY++;
			this.tmpDir=direction.east;
			break;
		case west:
			this.tmpPosX--;
			this.tmpPosY++;
			this.tmpDir=direction.south;			
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
			this.tmpPosX++;
			this.tmpPosY--;
			this.tmpDir=direction.east;
			break;
		case east:
			this.tmpPosX++;
			this.tmpPosY++;
			this.tmpDir=direction.south;
			break;
		case south:
			this.tmpPosX--;
			this.tmpPosY++;
			this.tmpDir=direction.west;
			break;
		case west:
			this.tmpPosX--;
			this.tmpPosY--;
			this.tmpDir=direction.north;
		}
	}
	
	
	/**
	 * Das Fahrzeug faehrt nach links (1 nach links und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	protected void moveHardLeft()
	{
		switch (dir)
		{
		case north:
			this.tmpPosX--;
			this.tmpDir=direction.west;
			break;
		case east:
			this.tmpPosY--;
			this.tmpDir=direction.north;
			break;
		case south:
			this.tmpPosX++;
			this.tmpDir=direction.east;
			break;
		case west:
			this.tmpPosY++;
			this.tmpDir=direction.south;			
		}

	}
	
	/**
	 * Das Fahrzeug faehrt nach rechts (1 nach rechts und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	protected void moveHardRight()
	{
		switch(dir)
		{
		case north:
			this.tmpPosX++;
			this.tmpDir=direction.east;
			break;
		case east:
			this.tmpPosY++;
			this.tmpDir=direction.south;
			break;
		case south:
			this.tmpPosX--;
			this.tmpDir=direction.west;
			break;
		case west:
			this.tmpPosY--;
			this.tmpDir=direction.north;
		}
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		synchronized(posX)
		{
			return posX;
		}
	}



	/**
	 * @return the posY
	 */
	public int getPosY() {
		synchronized(posY)
		{
			return posY;
		}
	}

	/**
	 * @return the iD
	 */
	public char getID() {
		return ID;
	}
	
	public direction getDirection()
	{
		synchronized(dir)
		{
			return this.dir;
		}
	}
		
	public String toString()
	{
		return new String("Car with ID '"+this.ID+"' got "+this.points+" points.");
	}
	
}
