public abstract class AbstractBox implements Pict {

	protected double factor = 1.0, height, width;

	public AbstractBox(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public AbstractBox() {
	}

	public void scale(double factor) {
		assert factor >= 0.1 && factor <= 10.0;
		this.factor = factor;
	}
}