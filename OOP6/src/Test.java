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
		ANAndroide b = new ANHilfskraft(1);
		b.setSkin(s);
		list.insert(b);
		
		/*
		
		b.setSkin(s);
		b.installSoftware(new SWHilfskraftSoftware(SWSecurityLevel.LEVEL2));

		list.insert(b);*/

		list.test();
	}

}
