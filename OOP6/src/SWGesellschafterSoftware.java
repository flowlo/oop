/**
 * Repraesentiert die Software eines Gesellschafters
 * 
 * @author Dominik
 * 
 */
public class SWGesellschafterSoftware extends SWBedienerSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWGesellschafterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnGesellschafter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
