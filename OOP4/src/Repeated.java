public class Repeated<P> implements Pict {
	
	final protected P[][] array;
	
	public Repeated(P[][] array) {
		int length = array.length;
		
		for (P[] item : array)
			if (item.length != length)
				throw new RuntimeException("Uebergebenes Array ist nicht \"quadratisch\".");
		
		this.array = array;
	}

	@Override
	public String toString() {
		String[][][] array = new String[this.array.length][this.array.length][];
		
		int height = -1, width = -1;
		
		// Hoehe und Breite des groessten Elements finden, um alle anderen aufzufuellen
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = this.array[i][j].toString().split("\n");
				if (array[i][j].length > height)
					height = array[i][j].length;
				
				for (String item : array[i][j])
					if (item.length() > width)
						width = item.length();
			}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < array.length; i++)
			for (int line = 0; line < height; line++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i][j].length <= line) {
						for (int n = 0; n < width; n++)
							sb.append(" ");
					}
					else {
						sb.append(array[i][j][line]);
						for (int n = array[i][j][line].length(); n < width; n++)
							sb.append(" ");
					}
				}
				sb.append("\n");
			}
				
		return sb.toString();
	}

	@Override
	public void scale(double factor) {
		// TODO Auto-generated method stub
	}
}
