




public class fastCar extends Autodrom{

	
	private GameField gamefield;
	private int posX;
	private int posY;
	private Car.direction dir;
	private int speed;
	
	public fastCar(GameField field, int startX, int startY,
			direction startDirection, char ID, int fieldsPerMilliSec) {
		super(ID);
		this.speed=fieldsPerMilliSec;
		this.gamefield=field;
		this.posX=startX;
		this.posY=startY;
		this.dir=startDirection;
		this.speed=fieldsPerMilliSec;
		field.addCar(startX, startY, this);
	}

	@Override
	public void run() {
		try
		{
		
		int count=0;
		while(!this.isInterrupted())
		{
			/*count++;
			if(count>50)
			{
				this.interrupt();
				break;
			}*/
			
			Thread.sleep(speed);
			
			int oldPosX=this.getPosX();
			int oldPosY=this.getPosY();
			direction oldDir=this.dir;
			move();
			if(!gamefield.moveCar(oldPosX, oldPosY,getPosX(),getPosY(), this))
			{
				this.posX=oldPosX;
				this.posY=oldPosY;
				this.dir=oldDir;
				addPoint();
			}
			//System.out.println(this.getPosX()+" "+this.getPosY());
			
		}
		}
		catch(InterruptedException e)
		{
			//System.out.println("fastCar interrupted");
		}
	}
	
	
	/**
	 * carlogic (im Moment Kreise)
	 */
	private void move()
	{
		switch(dir)
		{
		case north:
			if(getPosY()<=1) moveLeft();
			else moveForward();
			break;
		case east:
			if(getPosX()>=gamefield.getWidth()-2) moveLeft();
			else moveForward();
			break;
		case south:
			if(getPosY()>=gamefield.getHeight()-2) moveLeft();
			else moveForward();
			break;
		case west:
			if(getPosX()<=1)moveLeft();
			else moveForward();
		}
	}

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}
	
	
	
	/**
	 * das Fahrzeug faehrt nach vorne. Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	private void moveForward()
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
	private void moveLeft()
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
	private void moveRight()
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

}
