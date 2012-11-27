/**
 * Repraesentiert die Software eines Androiden
 * 
 * Zusicherungen:
 * * Sicherheitsstufe muss zwischen 1 und 5 liegen
 * 
 * @author Dominik
 * 
 */
public abstract class SWSoftware {
	protected SWSecurityLevel securityLevel;

	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWSoftware(SWSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	/**
	 * Gibt die Sicherheitsstufe der Software zuerueck
	 * 
	 * @return die Sicherheitsstufe
	 */
	public SWSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	/**
	 * Prueft, ob die Software auf einem Bauarbeiter installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnBauarbeiter(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einem Gesellschafter installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnGesellschafter(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einer Hilfskraft installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnHilfskraft(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einem Kaempfer installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnKaempfer(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einem Leibwaechter installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnLeibwaechter(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einem Objektbewacher installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnObjektbewacher(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einem Servicetechniker installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnServicetechniker(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}

	/**
	 * Prueft, ob die Software auf einem Transportarbeiter installiert ist
	 * 
	 * @param androide
	 */
	public void installedOnTransportarbeiter(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software fuer diesen Androiden");
	}
}
