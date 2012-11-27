/**
 * Repraesentiert die Software eines Transportarbeiters
 * 
 * @author Dominik
 * 
 */
public class SWTransportarbeiterSoftware extends SWSchwerarbeiterSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWTransportarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnTransportarbeiter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
