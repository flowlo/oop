/**
 * @author Simon
 * 
 *         Zusicherungen:
 *         * Das FastCar kann sich nur auf die Felder bewegen, die sich auf der Kante des umliegenden Rechtecks befinden, in welche das FastCar
 *         ausgerichtet ist.
 */
public class FastCar extends Autodrom {
	public FastCar(GameField field, int startX, int startY,
			direction startDirection, int speed, int moves, char ID) {
		super(field, startX, startY, startDirection, speed, moves, ID);
	}

	/**
	 * carlogic (random)
	 */
	@Override
	protected void move()
	{

		if (getPosX() <= 1)
		{
			switch (dir)
			{
			case north:
				moveRight();
				break;
			case south:
				moveLeft();
				break;
			case east:
				moveForward();
				break;
			case west:
				if (getPosY() < gamefield.getHeight() / 2)
					moveLeft();
				else
					moveRight();
			}
		}
		else if (getPosX() >= gamefield.getWidth() - 2)
		{
			switch (dir)
			{
			case north:
				moveLeft();
				break;
			case south:
				moveRight();
				break;
			case west:
				moveForward();
				break;
			case east:
				if (getPosY() < gamefield.getHeight() / 2)
					moveRight();
				else
					moveLeft();
			}
		}
		else if (getPosY() <= 1)
		{
			switch (dir)
			{
			case north:
				if (getPosX() < gamefield.getWidth() / 2)
					moveRight();
				else
					moveLeft();
				break;
			case south:
				moveForward();
				break;
			case east:
				moveRight();
				break;
			case west:
				moveLeft();
			}
		}
		else if (getPosY() >= gamefield.getHeight() - 2)
		{
			switch (dir)
			{
			case north:
				moveForward();
				break;
			case south:
				if (getPosX() < gamefield.getWidth() / 2)
					moveLeft();
				else
					moveRight();
				break;
			case east:
				moveLeft();
				break;
			case west:
				moveRight();
			}
		}
		else
		{
			int random = (int) Math.floor(Math.random() * 4);
			switch (random)
			{
			case 1:
				moveLeft();
				break;
			case 2:
				moveRight();
				break;
			default:
				moveForward();

			}
		}

	}

}
