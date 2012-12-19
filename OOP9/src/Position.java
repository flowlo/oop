/**
 * Eine Position repraesentiert einen Teil einer Bestellung. Sie beschreibt was fuer Kekse in
 * welcher Menge bestellt wurden.
 * 
 * @author Dominik
 * @author Simon
 * 
 */
public class Position {
	private int anzahl;
	private Form form;
	private Teigart teigart;
	private Fuellung fuellung;

	/**
	 * @param anzahl
	 * @param form
	 * @param teigart
	 * @param fuellung
	 *            wenn null, keine Fuellung --> einfacher Keks
	 *            sonst Doppelkeks
	 */
	public Position(int anzahl, Form form, Teigart teigart, Fuellung fuellung) {
		this.anzahl = anzahl;
		this.form = form;
		this.teigart = teigart;
		this.fuellung = fuellung;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public Form getForm() {
		return form;
	}

	public Teigart getTeigart() {
		return teigart;
	}

	public Fuellung getFuellung() {
		return fuellung;
	}

	@Override
	public String toString()
	{
		if (fuellung == null)
			return new String(anzahl + "x Keks der Form " + form + " aus " + teigart);
		else
			return new String(anzahl + "x Doppelkeks der Form " + form + " aus " + teigart + " mit der Fuellung " + fuellung);
	}
}
