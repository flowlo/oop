/*
 * Die Zeichen bleiben unveraendert.
 * Der Rand darf nicht aus Leerzeichen bestehen.
 * Wenn hoehe oder breite <=2 wird nur der Rand ausgegeben.
 * Der Rand darf anders sein als der Inhalt.
 * 
 */
public class Box extends AbstractBox {
	protected char inner, outer;
	

	
	public Box(double height, double width, char inner, char outer) {
		if(outer==' ')throw new IllegalArgumentException("Rand darf nicht ' ' sein");
		this.height=height;
		this.width=width;		
		this.inner = inner;
		this.outer = outer;
	}

	@Override
	public String toString() {
		
		int cHeight=(int) Math.ceil(height);
		int cWidth=(int) Math.ceil(width);		
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cHeight; i++) {
			for (int j = 0; j < cWidth; j++)
				sb.append((i == 0 || i == cHeight - 1 || j == 0 || j == cWidth - 1) ? outer : inner);

			sb.append(NL);
		}
		
		return sb.toString();
	}
}
