/**
 * Repraesentiert die Software einer Hilfskraft
 * 
 * @author Dominik
 * 
 */
public class SWHilfskraftSoftware extends SWBedienerSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWHilfskraftSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnHilfskraft(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
