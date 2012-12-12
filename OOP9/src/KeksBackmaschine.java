/**
 * Eine Keksbackmaschine kann Kekse einer bestimmten Form mit unterschiedlichen Teigarten
 * herstellen.
 * 
 * Zusicherungen
 * * Eine Maschine kann nur Kekse einer bestimmten Form herstellen.
 * 
 * @author Dominik
 * 
 */
public class KeksBackmaschine {
	private Form form;

	/**
	 * Initialisiert eine KeksBacmaschine fuer eine bestimmte Form.
	 * 
	 * @param form
	 *            die Form der zu backenden Kekse
	 */
	public KeksBackmaschine(Form form) {
		this.form = form;
	}

	/**
	 * Backt einen Keks einer bestimmten Teigart
	 * 
	 * @param teigart
	 *            die Teigart des Kekses
	 * @return den neuen Keks
	 */
	public Keks backe(Teigart teigart) {
		return null;
	}

}
