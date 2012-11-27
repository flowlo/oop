/**
 * Repraesentiert die Software eines Bedieners
 * 
 * Zusicherungen:
 * * Sicherheitsstufe muss 1 oder 2 sein
 * 
 * @author Dominik
 * 
 */
public abstract class SWBedienerSoftware extends SWSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWBedienerSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}
}
