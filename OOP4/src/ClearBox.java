public class ClearBox extends FramedBox {
	public ClearBox(int height, int width) {
		super(height, width, '*', ' ');
	}
	
	public double getAspectRatio() {
		return (double)width / height;
	}
}
