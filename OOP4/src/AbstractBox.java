/*Fuer erbende Klassen gilt: 	hoehe und breite werden im Konstruktor gesetzt und haben ein fixes Verhaeltnis zueinander.
* 								die Box ist ein Rechteck
*								bei der toString() Methode werden hoehe und breite aufgerundet								
*/
public abstract class AbstractBox implements Pict {

	protected static final String NL=System.getProperty("line.separator");
	
	protected double height, width;


	protected AbstractBox()
	{
		
	}
	
	//factor ist zwischen 0.1 und 10
	public void scale(double factor) {
		assert factor >= 0.1 && factor <= 10.0;
		this.height = height * factor;
		this.width = width * factor;
	}

	@Override
	public abstract String toString();
	

}