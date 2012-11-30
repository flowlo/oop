import java.lang.reflect.Field;


public class fastCar extends Autodrom{

	public fastCar(GameField field, int startX, int startY,
			direction startDirection, char ID) {
		super(field, startX, startY, startDirection, ID);
		gamefield.addCar(getPosX(), getPosY(), this);
	}

	@Override
	public void run() {
		try
		{
		
		int count=0;
		while(!this.isInterrupted())
		{
			count++;
			if(count>50)
			{
				this.interrupt();
				break;
			}
			
			Thread.sleep(100);
			
			int oldPosX=this.getPosX();
			int oldPosY=this.getPosY();
			move();
			gamefield.moveCar(oldPosX, oldPosY,getPosX(),getPosY(), this);
			//System.out.println(this.getPosX()+" "+this.getPosY());
			
		}
		}
		catch(InterruptedException e)
		{
			System.out.println("fastCar interrupted");
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
