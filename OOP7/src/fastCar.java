


public class fastCar extends Autodrom{

	
	public fastCar(GameField field, int startX, int startY,
			direction startDirection, char ID, int fieldsPerMilliSec) {
		super(field, startX, startY, startDirection, ID);
		this.speed=fieldsPerMilliSec;
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

}
