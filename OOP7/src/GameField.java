
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
	
	public Autodrom getField(int x, int y)
	{
		return field[x][y];
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
}
