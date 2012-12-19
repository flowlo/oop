/**
 * Eine Keksbackmaschine kann Kekse einer bestimmten Form mit unterschiedlichen Teigarten
 * herstellen.
 * 
 * Zusicherungen
 * * Eine Maschine kann nur Kekse einer bestimmten Form herstellen.
 * 
 * An dieser Stelle wurde auf eine moegliche Vererbungsbeziehung verzichtet. Es waere moeglich
 * gewesen, eine abstrakte KeksBackmaschine mit drei Unterklassen fuer jede Teigart zu erstellen.
 * Die hier vorliegende Loesung ist jedoch weit wartbarer, als unnoetige Vererbungsbeziehungen.
 * 
 * Weiters haben die KeksBackmaschine und die DoppelkeksBackmaschine keine Gemeinsamkeit, abseits
 * der backe-Methode. Die Methoden dieser beiden Klassen sich jedoch zu unterschiedlich, um eine
 * Vererbungsbeziehung darstellen zu koennen.
 * 
 * @author Dominik
 * 
 */
public class KeksBackmaschine {
	private Form form;

	/**
	 * Initialisiert eine KeksBackmaschine fuer eine bestimmte Form.
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
		return new Keks(form, teigart);
	}

}
