/*
 * Zeichen fuer Inhalt = Zeichen fuer Rand
 */
public class DarkBox extends AbstractBox {
	
	private char character;
	
	public DarkBox(int height, int width, char character) {
		if(character==' ')throw new IllegalArgumentException("Rand darf nicht ' ' sein");
		this.height=height;
		this.width=width;
		this.character=character;
	}
	
	public void setCharacter(char character) {
		this.character = character;
	}

	@Override
	public String toString() {
		int cHeight=(int) Math.ceil(height);
		int cWidth=(int) Math.ceil(width);		
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cHeight; i++) {
			for (int j = 0; j < cWidth; j++)
				sb.append(character);

			sb.append(NL);
		}
		
		return sb.toString();
	}
}
