public class FreeBox extends AbstractBox {

	protected String[] text;

	public FreeBox(String text) {
		//super(text.length() - text.replace("\n", "").length(), text.indexOf("\n"));

		this.text = text.split("\n");
		this.height = text.length();
		this.width = text.length();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				sb.append(text[i % text.length].charAt(j % text.length));

			sb.append('\n');
		}

		return sb.toString();
	}
}
