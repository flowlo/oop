/**
 * Repraesentiert die Software eines Servicetechnikers
 * 
 * @author Dominik
 * 
 */
public class SWServicetechnikerSoftware extends SWSchwerarbeiterSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWServicetechnikerSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnServicetechniker(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
