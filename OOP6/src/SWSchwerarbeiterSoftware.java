/**
 * Repraesentiert die Software eines Schwerarbeiters
 * 
 * Zusicherungen:
 * * Sicherheitsstufe muss 3 oder 4 sein
 * 
 * @author Dominik
 * 
 */
public abstract class SWSchwerarbeiterSoftware extends SWSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWSchwerarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}
}
