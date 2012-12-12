/**
 * Ein Keks hat eine bestimmte Form und eine bestimmte Teigart.
 * 
 * @author Dominik
 * 
 *         Zusicherungen
 *         * Jeder Keks kann entweder rund, Mond- oder Weihnachmann-foermig sein
 *         * Jeder Keks kann entweder aus Muerb-, Zimtstern- oder Schokoladeteig bestehen
 */
public class Keks extends KeksBasis {
	private Form form;
	private Teigart teigart;

	public Keks(Form form, Teigart teigart) {
		super();
		this.form = form;
		this.teigart = teigart;
	}

	public Form getForm() {
		return form;
	}

	public Teigart getTeigart() {
		return teigart;
	}
}
