
public class fastCar extends Autodrom{

	public fastCar(GameField field, int startX, int startY,
			direction startDirection) {
		super(field, startX, startY, startDirection);
		// TODO Auto-generated constructor stub
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
			
			move();
			System.out.println(this.getPosX()+" "+this.getPosY());
			
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
			if(getPosX()>=gamefield.getWidth()-1) moveLeft();
			else moveForward();
			break;
		case south:
			if(getPosY()>=gamefield.getHeight()-1) moveLeft();
			else moveForward();
			break;
		case west:
			if(getPosX()<=1)moveLeft();
			else moveForward();
		}
	}

}
