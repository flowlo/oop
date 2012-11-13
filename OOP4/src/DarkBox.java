public class DarkBox extends AbstractBox {
	protected char character;
	
	public DarkBox(double height, double width, char character) {
		super(height, width);
		this.character = character;
	}
	
	public void setCharacter(char character) {
		this.character = character;
	}

	@Override
	public String toString() {
		int height = (int)Math.ceil(this.height * this.factor), width = (int)Math.ceil(this.width * this.factor);
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < width; i++)
			line.append(character);
		
		line.append("\n");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < height; i++)
			sb.append(line);
		
		return sb.toString();
	}
}
