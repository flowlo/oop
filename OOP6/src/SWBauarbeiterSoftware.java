/**
 * Repraesentiert die Software eines Bauarbeiters
 * 
 * @author Dominik
 * 
 */
public class SWBauarbeiterSoftware extends SWSchwerarbeiterSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWBauarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnBauarbeiter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
