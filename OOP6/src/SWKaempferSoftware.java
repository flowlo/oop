/**
 * Repraesentiert die Software eines Kaempfers
 * 
 * Zusicherungen:
 * * Sicherheitsstufe muss 5 sein
 * 
 * @author Dominik
 * 
 */
public class SWKaempferSoftware extends SWSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWKaempferSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnKaempfer(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
