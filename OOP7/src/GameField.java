/**
 * @author Simon
 * 
 *         Zusicherungen:
 *         * Das Spielfeld ist rechtreckig
 *         * Es ist Schachbrettartig in Felder aufgeteilt
 *         * Auf jedem Feld befndet sich nur ein Autodrom
 */
public class GameField {

	private final int width;
	private final int height;

	private boolean raceStopped = false;

	private Autodrom[][] field;

	public GameField(int width, int height)
	{

		this.width = width;
		this.height = height;
		this.field = new Autodrom[width][height];
	}

	public synchronized void stopRace()
	{
		if (raceStopped)
			return;
		raceStopped = true;
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				if (field[x][y] != null)
				{
					System.out.println(field[x][y].toString());
					field[x][y].interrupt();
				}
			}
		}
		Test.nextTest();

	}

	public synchronized void addCar(int x, int y, Autodrom car)
	{
		if (field[x][y] == null)
			field[x][y] = car;
	}

	/**
	 * bewegt ein Auto
	 * 
	 * @param fromX
	 *            Start-Position
	 * @param fromY
	 *            Start-Position Y
	 * @param toX
	 *            Ziel-Position X
	 * @param toY
	 *            Ziel-Position Y
	 * @param car
	 *            Auto welches bewegt werden soll
	 * @return 0 wenn Ziel leer war, 1 wenn crash, 2 wenn frontal crash
	 */
	public synchronized int moveCar(int fromX, int fromY, int toX, int toY, Autodrom.direction newDir, Autodrom car)
	{
		if (raceStopped)
		{
			return 0;
		}
		if (fromX == toX && fromY == toY)
		{
			System.out.println("KEINE BEWEGUNG VON AUTO " + car.getID());
			return 0;
		}
		if (field[fromX][fromY] == car)
		{
			if (field[toX][toY] == null)
			{
				field[fromX][fromY] = null;
				field[toX][toY] = car;
				return 0;
			}
			else
			{

				//	System.out.println(this.toString());

				switch (newDir)
				{
				case north:
					if (field[toX][toY].getDirection() == Autodrom.direction.south)
						return 2;
					break;
				case south:
					if (field[toX][toY].getDirection() == Autodrom.direction.north)
						return 2;
					break;
				case east:
					if (field[toX][toY].getDirection() == Autodrom.direction.west)
						return 2;
					break;
				case west:
					if (field[toX][toY].getDirection() == Autodrom.direction.east)
						return 2;
					break;
				}
				field[toX][toY].crashed();
				System.out.println("Car " + car.getID() + " (dir " + newDir + ")" + " crashed into " + field[toX][toY].getID() + " (dir "
						+ field[toX][toY].getDirection() + ")");
				return 1;
			}
		}
		else
			throw new IllegalArgumentException("You are not on field (" + fromX + "/" + fromY + ")");
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	@Override
	public synchronized String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				if (field[x][y] == null)
					sb.append("O");
				else
					sb.append(field[x][y].getID());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
