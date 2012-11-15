public class Description implements Shorter<Description> {

	private String text;
	
	public Description(String text) {
		this.text = text;
	}

	@Override
	public boolean shorter(Description compare) {
		return toString().length() < compare.toString().length();
	}

	@Override
	public String toString() {
		return text;
	}

	public int getLines() {
		int lines = 1;
		
		for (char item : text.toCharArray())
			if (item == '\n')
				lines++;
		
		return lines;
	}
}
