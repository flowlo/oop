
public class GepanzerterSkin extends Skin {

	@Override
	public void vonBedienerGetragen(Bediener b) {
		System.out.println("! Nur Beschuetzer duerfen einen gepanzerten Skin haben. (setze ID auf null)");
		b.setUnvalid();		
	}

	@Override
	public void vonBeschuetzerGetragen(Beschuetzer b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonSchwerArbeiterGetragen(Schwerarbeiter s) {
		// TODO Auto-generated method stub
		
	}

}
