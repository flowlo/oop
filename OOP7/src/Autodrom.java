
public abstract class Autodrom extends Thread{
	
	protected GameField gamefield;
	protected int posX;
	protected int posY;
	protected direction dir;
	private final char ID;
	
	private int points;
	
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
	}
	
	public abstract void run();
	
	public int getPoints()
	{
		return points;
	}
	
	public void addPoint()
	{
		points++;
	}
	public void crashed()
	{
		points--;
	}
	
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
		
		//TODO: synchronized update GameField and check crash
	}
	
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
		
		//TODO: synchronized update GameField and check crash
	}
	
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
		//TODO: synchronized update GameField and check crash
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


	
}
