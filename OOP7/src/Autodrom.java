
public abstract class Autodrom extends Thread implements Car{
	private final char ID;			//mit dieser "ID" wird es in der toString methode von GameField dargestellt. es koennen auch mehrere das gleiche Zeichen haben
	
	private int points;				//AUF SYNC ACHTEN punkte (+1 pro rammen / -1 pro gerammt werden)
	
	
	public Autodrom(char ID)
	{
		this.ID=ID;
	}
	
	public abstract void run();

	
	public int getPoints()
	{
		return points;
	}
	
	public synchronized void addPoint()
	{
		points++;
	}
	public synchronized void crashed()
	{
		points--;
	}
	



	/**
	 * @return the iD
	 */
	public char getSymbol() {
		return ID;
	}


	public String toString()
	{
		return new String("Car with ID '"+this.ID+"' got "+this.points+" points.");
	}
	
}
