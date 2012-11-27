/**
 * Repraesentiert die Software eines Beschuetzers
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
