/**
 * Repraesentiert die Software eines Beschuetzers
 * 
 * Zusicherungen:
 * * Sicherheitsstufe muss 4 oder 5 sein (wegen Kaempfern)
 * 
 * @author Dominik
 * 
 */
public abstract class SWBeschuetzerSoftware extends SWSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWBeschuetzerSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}
}
