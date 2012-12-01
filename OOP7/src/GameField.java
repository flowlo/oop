
public class GameField {
	
	private final int width;
	private final int height;
	
	private boolean raceStopped=false;
	
	private Autodrom[][] field;
	
	public GameField(int width, int height)
	{
		this.width=width;
		this.height=height;
		this.field=new Autodrom[width][height];
	}
	
	public synchronized void stopRace()
	{
		raceStopped=true;
		for(int x=0;x<width;x++)
		{
			for(int y=0;y<height;y++)
			{
				if(field[x][y]!=null)
				{
					System.out.println(field[x][y].toString());
					field[x][y].interrupt();
				}
			}
		}
	}
	
	public synchronized void addCar(int x, int y, Autodrom car)
	{
		if(field[x][y]==null)field[x][y]=car;
	}
	
	/**
	 * bewegt ein Auto
	 * @param fromX Start-Position X
	 * @param fromY Start-Position Y
	 * @param toX	Ziel-Position X
	 * @param toY Ziel-Position Y
	 * @param car Auto welches bewegt werden soll
	 * @return true wenn Ziel leer war, false wenn crash
	 */
	public synchronized boolean moveCar(int fromX, int fromY, int toX, int toY, Autodrom car)
	{
		if(raceStopped)
		{
			return true;
		}
		if(field[fromX][fromY]==car)
		{
			if(field[toX][toY]==null)
			{
				field[fromX][fromY]=null;
				field[toX][toY]=car;
				return true;
			}
			else
			{	
				field[toX][toY].crashed();
				System.out.println("Car "+car.getID()+" crashed into "+field[toX][toY].getID());
				System.out.println(this.toString());
				return false;
			}
		}
		else throw new IllegalArgumentException("You are not on field ("+fromX+"/"+fromY+")");
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
