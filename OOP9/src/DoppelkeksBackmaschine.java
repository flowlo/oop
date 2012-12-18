/**
 * Eine DoppelkeksBackmaschine baeckt Doppelkekse. Dafuer muss ein einfacher Keks eingelegt
 * werden.
 * 
 * Die KeksBackmaschine und die DoppelkeksBackmaschine haben keine Gemeinsmkeit, abseits
 * der backe-Methode. Die Methoden dieser beiden Klassen sich jedoch zu unterschiedlich, um eine
 * Vererbungsbeziehung darstellen zu koennen.
 * 
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
		if(ladung==null) throw new BackmaschineNichtBeladenException();
		else
		{
			Doppelkeks result=new Doppelkeks(fuellung, ladung,ladung.clone());
			this.ladung=null;
			return result;
		}
	}

	/**
	 * Beladet die Backmaschine mit einem Keks, der als Vorlage fuer die Doppelkeksproduktion
	 * dient. Der Keks wird fuer den naechten Doppelkeks verwendet. Anschliessend ist die
	 * Maschine nicht mehr beladen.
	 * 
	 * @param keks
	 */
	public void lade(Keks keks) {
		this.ladung=keks;
	}

}
