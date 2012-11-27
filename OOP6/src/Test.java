public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verwaltung list = new Verwaltung();
		list.test();

		SKSkin s = new SKHochfesterSkin();
		SKSkin s2 = new SKHochfesterSkin();
		SWSoftware software = new SWTransportarbeiterSoftware(new SWSecurityLevel3());
		SWSoftware software2 = new SWTransportarbeiterSoftware(new SWSecurityLevel4());
		ANAndroide a = new ANTransportarbeiter(1, s, software);
		list.insert(a);
		ANAndroide b = new ANTransportarbeiter(1, s2, software);
		list.insert(b);
		b = new ANServicetechniker(1, s, software2);
		list.insert(b);

		list.test();
		//System.out.println(list.find(1));
		list.printHistory(1);
	}

}
