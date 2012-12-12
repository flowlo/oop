/**
 * Eine DoppelkeksBackmaschine baeckt Doppelkekse. Dafuer muss ein einfacher Keks eingelegt
 * werden.
 * 
 * @author Dominik
 * 
 */
public class DoppelkeksBackmaschine {
	private Keks ladung;

	/**
	 * Baeckt einen zweiten Keks, mit der Vorlage der aktuellen Ladung und einer bestimmten
	 * Fuellung.
	 * 
	 * Zusicherungen:
	 * * Backmaschine muss beim Aufruf der Methode beladen sein
	 * 
	 * @param fuellung
	 *            die Fuellung des Doppelkekses
	 * @return ein Doppelkeks
	 * @throws BackmaschineNichtBeladenException
	 *             wenn die Maschine nicht beladen ist.
	 */
	public Doppelkeks backe(Fuellung fuellung) throws BackmaschineNichtBeladenException {
		return null;
	}

	/**
	 * Beladet die Backmaschine mit einem Keks, der als Vorlage fuer die Doppelkeksproduktion
	 * dient. Der Keks wird fuer den naechten Doppelkeks verwendet. Anschliessend ist die
	 * Maschine nicht mehr beladen.
	 * 
	 * @param keks
	 */
	public void lade(Keks keks) {

	}

}
