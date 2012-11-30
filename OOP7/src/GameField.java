
public class GameField {
	
	private final int width;
	private final int height;
	
	private Autodrom[][] field;
	
	public GameField(int width, int height)
	{
		this.width=width;
		this.height=height;
		this.field=new Autodrom[width][height];
	}
	
	public synchronized Autodrom getField(int x, int y)
	{
		return field[x][y];
	}
	
	public synchronized void addCar(int x, int y, Autodrom car)
	{
		if(field[x][y]==null)field[x][y]=car;
	}
	
	public synchronized void moveCar(int fromX, int fromY, int toX, int toY, Autodrom car)
	{
		if(field[fromX][fromY]==car&&field[toX][toY]==null)
		{
			field[fromX][fromY]=null;
			field[toX][toY]=car;
		}
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
	
	public synchronized String toString()
	{
		StringBuilder sb=new StringBuilder();
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{
				if(field[x][y]==null) sb.append("O");
				else sb.append(field[x][y].getID());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
