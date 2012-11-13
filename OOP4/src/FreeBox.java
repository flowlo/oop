/*
 * Text ist unveraenderbar.
 */
public class FreeBox extends AbstractBox {

	protected String[] text;

	public FreeBox(String text) {
		this.text = text.split("\n");
		
		int l=this.text[0].length();
		for(int x=1;x<text.length();x++)
		{
			if(this.text[x].length()!=l) throw new IllegalArgumentException("Text muss rechteckig sein!"); 
		}		
		this.height = this.text.length;
		this.width = this.text[0].length();
	}

	@Override
	public String toString() {
		int cHeight=(int) Math.ceil(height);
		int cWidth=(int) Math.ceil(width);		
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cHeight; i++) {
			for (int j = 0; j < cWidth; j++)
				sb.append(text[i % text.length].charAt(j % text[i % text.length].length()));

			sb.append(NL);
		}

		return sb.toString();
	}
}
