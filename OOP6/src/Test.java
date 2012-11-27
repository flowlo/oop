/**
 * Test-Klasse
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class Test {

	/**
	 * Test-Funktion
	 * 
	 * @param args
	 *            werden ignoriert
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verwaltung list = new Verwaltung();
		list.size();

		SKSkin s = new SKHochfesterSkin();
		SKSkin s2 = new SKHochfesterSkin();
		SWSoftware software = new SWTransportarbeiterSoftware(new SWSecurityLevel4());
		SWSoftware software2 = new SWTransportarbeiterSoftware(new SWSecurityLevel3());
		SWSoftware software3 = new SWServicetechnikerSoftware(new SWSecurityLevel4());
		SWSoftware software4 = new SWServicetechnikerSoftware(new SWSecurityLevel3());
		ASAktorenSet aktoren = new ASSchwereAktoren();
		ASAktorenSet aktoren2 = new ASLeichteAktoren();
		ASAktorenSet aktoren3 = new ASAwesomeAktoren();
		ANAndroide a = new ANTransportarbeiter(1, s, software, aktoren);
		list.insert(a);
		ANAndroide b = new ANTransportarbeiter(1, s2, software, aktoren2);
		list.insert(b);
		b = new ANTransportarbeiter(1, s, software2, aktoren2);
		list.insert(b);
		b = new ANServicetechniker(1, s, software3, aktoren2);
		list.insert(b);
		b = new ANServicetechniker(1, s, software4, aktoren2);
		list.insert(b);
		b = new ANServicetechniker(1, s, software3, aktoren3);
		list.insert(b);
		b = new ANServicetechniker(1, s, software, aktoren2);
		list.insert(b);

		list.size();
		//System.out.println(list.find(1));
		list.printHistory(1);
	}
}
