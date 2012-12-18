/**
 * Ein Keks hat eine bestimmte Form und eine bestimmte Teigart.
 * 
 * Zusicherungen
 * * Jeder Keks kann entweder rund, Mond- oder Weihnachmann-foermig sein
 * * Jeder Keks kann entweder aus Muerb-, Zimtstern- oder Schokoladeteig bestehen
 * 
 * @author Dominik
 */
public class Keks extends KeksBasis {
	private Form form;
	private Teigart teigart;

	public Keks(Form form, Teigart teigart) {
		this.form = form;
		this.teigart = teigart;
	}

	@Override
	public Keks clone() {
		return new Keks(form, teigart);
	}

	@Override
	public String toString() {
		return new String("Keks mit Form: "+form+"; Teigart: "+teigart);
	}
}
