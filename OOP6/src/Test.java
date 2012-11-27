public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SKSkin s = new SKSensitiveSkin();
		ANAndroide a = new ANHilfskraft(1);
		a.setSkin(s);
		a.checkSkin();

		s = new SKHochfesterSkin();
		a.setSkin(s);
		a.checkSkin();
	}

}
