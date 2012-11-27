/**
 * Repraesentiert die Software eines Objektbewachers
 * 
 * Zusicherungen:
 * * Sicherheitsstufe muss 4 sein
 * 
 * @author Dominik
 * 
 */
public class SWObjektbewacherSoftware extends SWSoftware {
	/**
	 * Konstruktor
	 * 
	 * @param securityLevel
	 *            die Sicherheitsstufe der Software
	 */
	public SWObjektbewacherSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnObjektbewacher(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
