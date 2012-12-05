


public class FlexibleCar extends Autodrom{

	private int nextX, nextY;
	
	public FlexibleCar(GameField field, int startX, int startY,
			direction startDirection, int speed,int moves, char ID) {
		super(field, startX, startY, startDirection,  moves, speed,ID);
		switch(startDirection)
		{
		case north:
			nextX=startX;
			nextY=startY-1;
			break;
		case south:
			nextX=startX;
			nextY=startY+1;
			break;
		case east:
			nextX=startX+1;
			nextY=startY;
			break;
		case west:
			nextX=startX-1;
			nextY=startY;
		}
	}

	
	
	//random
	protected void move() {	;
		if(frontalCrash||(nextX==posX&&nextY==posY))
		{
			frontalCrash=false;
			nextX=(int)Math.floor(Math.random()*gamefield.getWidth());
			nextY=(int)Math.floor(Math.random()*gamefield.getHeight());
		}
		if(posX<nextX)	//fahre zuerst in X-Richtung
		{
			switch(dir)
			{
			case east:
				moveForward();
				break;
			case north: moveHardRight();
			break;
			case south: moveHardLeft();
			break;
			case west:
				if(posY<gamefield.getWidth()/2) moveHardLeft();
				else moveHardRight();
			}
		}
		else if(posX>nextX)
		{
			switch(dir)
			{
			case west: 
				moveForward();
				break;
			case south: moveHardRight();
			break;
			case north: moveHardLeft();
			break;
			case east:
				if(posY>gamefield.getWidth()/2) moveHardLeft();
				else moveHardRight();
			}
		}
		else if(posY<nextY)		//und dann in Y Richtung
		{
				switch(dir)
				{
				case south: 
					moveForward();
					break;
				case east: moveHardRight();
				break;
				case west: moveHardLeft();
				break;
				case north:
					if(posX>gamefield.getWidth()/2) moveHardLeft();
					else moveHardRight();
				}
		}
	
		else if(posY>nextY)
			{
				switch(dir)
				{
				case north: 
					moveForward();
					break;
				case west: moveHardRight();
				break;
				case east: moveHardLeft();
				break;
				case south:
					if(posX<gamefield.getWidth()/2) moveHardLeft();
					else moveHardRight();
				}
			}
		
	}
	


	
	
	



	




}
