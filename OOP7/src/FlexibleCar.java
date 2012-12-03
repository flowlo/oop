



public class FlexibleCar extends Autodrom{

	private boolean mainDirection;
	
	private GameField gamefield;
	private int posX;
	private int posY;
	private Car.direction dir;
	private int speed;
	
	public FlexibleCar(GameField field, int startX, int startY,
			direction startDirection, char ID, int speed) {
		super(ID);
		this.speed=speed;
		this.gamefield=field;
		this.posX=startX;
		this.posY=startY;
		this.dir=startDirection;
		mainDirection=false;
		field.addCar(startX, startY, this);
	}

	@Override
	public void run() {
		try
		{
		
		int count=0;
		while(!this.isInterrupted())
		{
		/*	count++;
			if(count>50)
			{
				this.interrupt();
				break;
			}
			*/
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
			//System.out.println("flexibleCar interrupted");
		}
	}
	
	//fahre Schlangenlinien
	private void move() {
		switch(dir)
		{
		case north:
			if(getPosY()<=0)
			{
				if(this.mainDirection)
				{
					if(getPosX()>=gamefield.getWidth()-1)//rechts angekommen-aendere Hauptrichtung
					{
						mainDirection=!mainDirection;
						moveHardLeft();
					}
					else this.moveHardRight();
				}	
				else 
				{
					if(getPosX()<=0)//links angekommen-aendere Hauptrichtung
					{
						mainDirection=!mainDirection;
						moveHardRight();
					}
					else this.moveHardLeft();
				}
			}
			else this.moveForward();
			break;
		case south:
			if(getPosY()>=gamefield.getHeight()-1)
			{
				if(this.mainDirection)
				{
					if(getPosX()>=gamefield.getWidth()-1)//rechts angekommen-aendere Hauptrichtung
					{
						mainDirection=!mainDirection;
						moveHardRight();
					}
					else this.moveHardLeft();
				}	
				else 
				{
					if(getPosX()<=0)//links angekommen-aendere Hauptrichtung
					{
						mainDirection=!mainDirection;
						moveHardLeft();
					}
					else this.moveHardRight();
				}
			}
			else moveForward();
			break;
		case east:
			if(getPosY()<=0) moveHardRight();
			else moveHardLeft();
			break;
		case west:
			if(getPosY()<=0)moveHardLeft();
			else moveHardRight();
			
		}
	}
	

	/**
	 * Das Fahrzeug faehrt nach links (1 nach links und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	private void moveHardLeft()
	{
		switch (dir)
		{
		case north:
			this.posX--;
			this.dir=direction.west;
			break;
		case east:
			this.posY--;
			this.dir=direction.north;
			break;
		case south:
			this.posX++;
			this.dir=direction.east;
			break;
		case west:
			this.posY++;
			this.dir=direction.south;			
		}

	}
	
	
	/**
	 * Das Fahrzeug faehrt nach rechts (1 nach rechts und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	private void moveHardRight()
	{
		switch(dir)
		{
		case north:
			this.posX++;
			this.dir=direction.east;
			break;
		case east:
			this.posY++;
			this.dir=direction.south;
			break;
		case south:
			this.posX--;
			this.dir=direction.west;
			break;
		case west:
			this.posY--;
			this.dir=direction.north;
		}
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

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}




}