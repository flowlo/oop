public class FramedBox extends AbstractBox {
	
	protected char inner, outer;
	
	public FramedBox(int height, int width, char inner, char outer) {
		super(height, width);
		
		this.inner = inner;
		this.outer = outer;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
					sb.append((i == 0 || i == height - 1 || j == 0 || j == width - 1) ? outer : inner);

			sb.append('\n');
		}
		
		return sb.toString();
	}
}
