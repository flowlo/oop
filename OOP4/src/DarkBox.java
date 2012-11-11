public class DarkBox extends FramedBox {
	public DarkBox(int height, int width, char character) {
		super(height, width, character, character);
	}
	
	public void setCharacter(char character) {
		this.inner = this.outer = character;
	}
}
