public class ClearBox extends Box {
	public ClearBox(double height, double width) {
		super(height, width, ' ', '*');
	}
	
	public double getAspectRatio() {
		return width / height;
	}
}
