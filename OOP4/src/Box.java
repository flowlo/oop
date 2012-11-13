// Zusicherung "Die Raender des Rechtecks koennen aus anderen Zeichen bestehen als der Inhalt."
// Zusicherung "Die beiden zu verwendenden Zeichen werden im Konstruktor gesetzt und bleiben danach unveraendert.

public class Box extends AbstractBox {
	protected final char inner, outer;
	
	public Box(int height, int width) {
		this(height, width, '.', 'o');
	}
	
	protected Box(double height, double width, char inner, char outer) {
		super(height, width);
		
		assert outer != ' ';
		
		this.inner = inner;
		this.outer = outer;
	}

	@Override
	public String toString() {
		int height = (int)Math.ceil(this.height * this.factor), width = (int)Math.ceil(this.width * this.factor);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				sb.append((i == 0 || i == height - 1 || j == 0 || j == width - 1) ? outer : inner);

			sb.append('\n');
		}
		
		return sb.toString();
	}
}
