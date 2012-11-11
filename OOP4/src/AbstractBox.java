public abstract class AbstractBox implements Pict {

	protected int height, width;

	public AbstractBox(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public AbstractBox() {
	}

	public void scale(double factor) {
		this.height = (int)Math.ceil(height * factor);
		this.width = (int)Math.ceil(width * factor);
	}

	@Override
	public abstract String toString();
}
