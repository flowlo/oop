/*
 * Rand immer '*'
 * Inhalt immer ' '
 */
public class ClearBox extends Box {
	public ClearBox(int height, int width) {
		super(height, width, ' ', '*');
	}
	
	private ClearBox(double height, double width, char inner, char outer) //hide super-constructor
	{
		super(height,width,' ','*');
	}
	
	public double getAspectRatio() {
		return width / height;
	}
}
