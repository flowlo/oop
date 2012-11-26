
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Skin s=new SensitiveSkin();
		Androide a=new Hilfskraft();
		a.setSkin(s);
		a.checkSkin();
		
		s=new HochfesterSkin();
		a.setSkin(s);
		a.checkSkin();
	}

}
