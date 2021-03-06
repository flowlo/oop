/**
 * @author Simon
 * 
 *         Zusicherungen:
 *         * Das Flexible kann sich sowohl auf die Felder bewegen, die sich auf der Kante des umliegenden Rechtecks befinden, in welche das FastCar
 *         ausgerichtet ist, als auch auf die beiden parallel liegenden Felder.
 */
public class FlexibleCar extends Autodrom {

	private int nextX, nextY;

	public FlexibleCar(GameField field, int startX, int startY,
			direction startDirection, int speed, int moves, char ID) {
		super(field, startX, startY, startDirection, moves, speed, ID);
		switch (startDirection)
		{
		case north:
			nextX = startX;
			nextY = startY - 1;
			break;
		case south:
			nextX = startX;
			nextY = startY + 1;
			break;
		case east:
			nextX = startX + 1;
			nextY = startY;
			break;
		case west:
			nextX = startX - 1;
			nextY = startY;
		}
	}

	//random
	@Override
	protected void move() {
		;
		if (frontalCrash || (nextX == getPosX() && nextY == getPosY()))
		{
			frontalCrash = false;
			nextX = (int) Math.floor(Math.random() * gamefield.getWidth());
			nextY = (int) Math.floor(Math.random() * gamefield.getHeight());
		}
		if (getPosX() < nextX) //fahre zuerst in X-Richtung
		{
			switch (dir)
			{
			case east:
				moveForward();
				break;
			case north:
				moveHardRight();
				break;
			case south:
				moveHardLeft();
				break;
			case west:
				if (getPosY() < gamefield.getWidth() / 2)
					moveHardLeft();
				else
					moveHardRight();
			}
		}
		else if (getPosX() > nextX)
		{
			switch (dir)
			{
			case west:
				moveForward();
				break;
			case south:
				moveHardRight();
				break;
			case north:
				moveHardLeft();
				break;
			case east:
				if (getPosY() > gamefield.getWidth() / 2)
					moveHardLeft();
				else
					moveHardRight();
			}
		}
		else if (getPosY() < nextY) //und dann in Y Richtung
		{
			switch (dir)
			{
			case south:
				moveForward();
				break;
			case east:
				moveHardRight();
				break;
			case west:
				moveHardLeft();
				break;
			case north:
				if (getPosX() > gamefield.getWidth() / 2)
					moveHardLeft();
				else
					moveHardRight();
			}
		}

		else if (getPosY() > nextY)
		{
			switch (dir)
			{
			case north:
				moveForward();
				break;
			case west:
				moveHardRight();
				break;
			case east:
				moveHardLeft();
				break;
			case south:
				if (getPosX() < gamefield.getWidth() / 2)
					moveHardLeft();
				else
					moveHardRight();
			}
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
			this.tmpPosX--;
			this.tmpDir = direction.west;
			break;
		case east:
			this.tmpPosY--;
			this.tmpDir = direction.north;
			break;
		case south:
			this.tmpPosX++;
			this.tmpDir = direction.east;
			break;
		case west:
			this.tmpPosY++;
			this.tmpDir = direction.south;
		}

	}

	/**
	 * Das Fahrzeug faehrt nach rechts (1 nach rechts und Richtungsaenderung). Diese Methode ist unabhaengig von einem Spielfeld.
	 */
	private void moveHardRight()
	{
		switch (dir)
		{
		case north:
			this.tmpPosX++;
			this.tmpDir = direction.east;
			break;
		case east:
			this.tmpPosY++;
			this.tmpDir = direction.south;
			break;
		case south:
			this.tmpPosX--;
			this.tmpDir = direction.west;
			break;
		case west:
			this.tmpPosY--;
			this.tmpDir = direction.north;
		}
	}

}
