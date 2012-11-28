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
		Verwaltung list = new Verwaltung();
		list.size();

		SKSkin skh = new SKHochfesterSkin(),
				skb = new SKSensitiveSkin(),
				skg = new SKGepanzerterSkin();
		SWSecurityLevel sec1 = new SWSecurityLevel1(),
				sec2 = new SWSecurityLevel2(),
				sec3 = new SWSecurityLevel3(),
				sec4 = new SWSecurityLevel4();
		SWSoftware swg = new SWGesellschafterSoftware(sec1),
				swh1 = new SWHilfskraftSoftware(sec1),
				swh2 = new SWHilfskraftSoftware(sec2),
				swt3 = new SWTransportarbeiterSoftware(sec3),
				swt4 = new SWTransportarbeiterSoftware(sec4),
				swb3 = new SWBauarbeiterSoftware(sec3),
				swb4 = new SWBauarbeiterSoftware(sec4),
				sws3 = new SWServicetechnikerSoftware(sec3),
				sws4 = new SWServicetechnikerSoftware(sec4),
				swo = new SWObjektbewacherSoftware(sec4),
				swl = new SWLeibwaechterSoftware(sec4),
				swk = new SWKaempferSoftware(new SWSecurityLevel5());
		ASAktorenSet kw05 = new ASLameAktoren(),
				kw3 = new ASLeichteAktoren(),
				kw9 = new ASSchwereAktoren(),
				kw50 = new ASAwesomeAktoren(); 
		
		ANAndroide[] test = new ANAndroide[] {
			new ANGesellschafter(0, skb, swg, kw05),
			
			new ANHilfskraft(1, skb, swh1, kw05),
			new ANHilfskraft(2, skb, swh2, kw05),
			
			new ANBauarbeiter(3, skb, swb3, kw3),
			new ANBauarbeiter(4, skh, swb3, kw3),
			new ANBauarbeiter(5, skb, swb3, kw05),
			new ANBauarbeiter(6, skh, swb3, kw05),
			new ANBauarbeiter(7, skb, swb4, kw3),
			new ANBauarbeiter(8, skh, swb4, kw3),
			new ANBauarbeiter(9, skb, swb4, kw05),
			new ANBauarbeiter(10, skh, swb4, kw05),
			new ANBauarbeiter(11, skb, swb4, kw9),
			new ANBauarbeiter(12, skh, swb4, kw9),
			
			new ANServicetechniker(13, skb, sws3, kw3),
			new ANServicetechniker(14, skh, sws3, kw3),
			new ANServicetechniker(15, skb, sws3, kw05),
			new ANServicetechniker(16, skh, sws3, kw05),
			new ANServicetechniker(17, skb, sws4, kw3),
			new ANServicetechniker(18, skh, sws4, kw3),
			new ANServicetechniker(19, skb, sws4, kw05),
			new ANServicetechniker(20, skh, sws4, kw05),
			new ANServicetechniker(21, skb, sws4, kw9),
			new ANServicetechniker(22, skh, sws4, kw9),
			
			new ANTransportarbeiter(23, skb, swt3, kw3),
			new ANTransportarbeiter(24, skh, swt3, kw3),
			new ANTransportarbeiter(25, skb, swt3, kw05),
			new ANTransportarbeiter(26, skh, swt3, kw05),
			new ANTransportarbeiter(27, skb, swt4, kw3),
			new ANTransportarbeiter(28, skh, swt4, kw3),
			new ANTransportarbeiter(29, skb, swt4, kw05),
			new ANTransportarbeiter(30, skh, swt4, kw05),
			new ANTransportarbeiter(31, skb, swt4, kw9),
			new ANTransportarbeiter(32, skh, swt4, kw9),
			
			new ANObjektbewacher(33, skb, swo, kw3),
			new ANObjektbewacher(34, skh, swo, kw3),
			new ANObjektbewacher(35, skg, swo, kw3),
			new ANObjektbewacher(36, skb, swo, kw05),
			new ANObjektbewacher(37, skh, swo, kw05),
			new ANObjektbewacher(38, skg, swo, kw05),
			new ANObjektbewacher(39, skb, swo, kw9),
			new ANObjektbewacher(40, skh, swo, kw9),
			new ANObjektbewacher(41, skg, swo, kw9),
			
			new ANLeibwaechter(43, skb, swl, kw3),
			new ANLeibwaechter(44, skh, swl, kw3),
			new ANLeibwaechter(45, skg, swl, kw3),
			new ANLeibwaechter(46, skb, swl, kw05),
			new ANLeibwaechter(47, skh, swl, kw05),
			new ANLeibwaechter(48, skg, swl, kw05),
			new ANLeibwaechter(49, skb, swl, kw9),
			new ANLeibwaechter(50, skh, swl, kw9),
			new ANLeibwaechter(51, skg, swl, kw9),
			
			new ANKaempfer(52, skh, swk, kw05),
			new ANKaempfer(53, skg, swk, kw05),
			new ANKaempfer(54, skb, swk, kw05),
			new ANKaempfer(55, skh, swk, kw3),
			new ANKaempfer(56, skg, swk, kw3),
			new ANKaempfer(57, skb, swk, kw3),
			new ANKaempfer(58, skh, swk, kw9),
			new ANKaempfer(59, skg, swk, kw9),
			new ANKaempfer(60, skb, swk, kw9),
			new ANKaempfer(61, skh, swk, kw50),
			new ANKaempfer(62, skg, swk, kw50),
			new ANKaempfer(63, skb, swk, kw50)
		};
		
		for (ANAndroide androide : test)
			list.insert(androide);

		list.size();
		
		test = new ANAndroide[] {
			new ANGesellschafter(64, skg, swk, kw50),
			new ANHilfskraft(65, skh, swh1, kw05),
			new ANTransportarbeiter(66, skh, swt3, kw50),
			new ANServicetechniker(67, skg, sws3, kw05),
			new ANGesellschafter(68, skh, swg, kw05),
			new ANObjektbewacher(69, skh, swo, kw50),
			new ANBauarbeiter(70, skh, sws4, kw9),
			new ANGesellschafter(71, skg, swg, kw3)
		};

		for (ANAndroide androide : test)
			list.insert(androide);

		list.size();
		
		test = new ANAndroide[] {
			// AktorenSet Upgrade (valid)
			new ANKaempfer(60, skb, swk, kw50),
			// AktorenSet Downgrade (valid)
			new ANBauarbeiter(11, skb, swb4, kw3),
			// Software überschreiben (valid)
			new ANObjektbewacher(37, skg, new SWObjektbewacherSoftware(sec4), kw05),
			// Skin wechseln (valid)
			new ANObjektbewacher(37, skh, new SWObjektbewacherSoftware(sec4), kw05)
		};
		
		System.out.println("Valide Aenderungen an existierenden Anroiden:");
		for (ANAndroide androide : test)
			list.insert(androide);
		
		test = new ANAndroide[] {
			// AktorenSet Upgrade (invalid)
			new ANGesellschafter(0, skb, swg, kw50),
			// Software überschreiben (invalid)
			new ANObjektbewacher(37, skg, new SWObjektbewacherSoftware(sec1), kw05),
			// Skin wechseln (invalid)
			new ANTransportarbeiter(29, skg, swt4, kw05)
		};
		
		System.out.println("Invalide Aenderungen an existierenden Anroiden:");
		for (ANAndroide androide : test)
			list.insert(androide);
	}
}
