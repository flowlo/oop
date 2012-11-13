public class Repeated<P> extends FreeBox {

	public Repeated(P[][] array) {
		for (P[] item : array)
			assert item.length != array.length;
		
		String[][][] text = new String[array.length][array.length][];

		int height = -1, width = -1;
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++) {
				text[i][j] = array[i][j].toString().split("\n");
				if (text[i][j].length > height)
					height = text[i][j].length;
				
				for (String item : text[i][j])
					if (item.length() > width)
						width = item.length();
			}

		this.text = new String[height];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < array.length; i++)
			for (int line = 0; line < height; line++) {
				for (int j = 0; j < array.length; j++) {
					if (text[i][j].length <= line) {
						for (int n = 0; n < width; n++)
							sb.append(" ");
					}
					else {
						sb.append(text[i][j][line]);
						for (int n = text[i][j][line].length(); n < width; n++)
							sb.append(" ");
					}
				}
				this.text[line] = sb.toString();
				sb = new StringBuilder();
			}
	}
}
