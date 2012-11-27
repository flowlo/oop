/**
 * Repraesentiert die Software eines Leibwaechters
 * 
 * @author Dominik
 * 
 */
public class SWLeibwaechterSoftware extends SWSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWLeibwaechterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnLeibwaechter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
