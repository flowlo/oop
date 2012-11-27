/**
 * Repraesentiert die Software eines Bedieners
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
