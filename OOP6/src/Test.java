public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verwaltung list = new Verwaltung();
		list.test();

		SKSkin s = new SKSensitiveSkin();
		//s = new SKHochfesterSkin();
		ANAndroide a = new ANHilfskraft(1);
		a.setSkin(s);
		list.insert(a);

		ANAndroide b = new ANHilfskraft(2);
		b.setSkin(s);
		b.installSoftware(new SWHilfskraftSoftware(SWSecurityLevel.LEVEL3));
		System.out.println(b);
		b.installSoftware(new SWGesellschafterSoftware(SWSecurityLevel.LEVEL1));
		System.out.println(b);
		b.installSoftware(new SWBauarbeiterSoftware(SWSecurityLevel.LEVEL2));
		System.out.println(b);
		b.installSoftware(new SWHilfskraftSoftware(SWSecurityLevel.LEVEL2));
		System.out.println(b);
		b.installSoftware(new SWHilfskraftSoftware(SWSecurityLevel.LEVEL1));
		System.out.println(b);
		list.insert(b);

		list.test();
	}

}
