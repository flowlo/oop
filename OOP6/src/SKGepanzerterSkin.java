
public class SKGepanzerterSkin extends SKSkin {

	@Override
	public void vonBedienerGetragen(ANBediener b) {
		System.out.println("! Nur Beschuetzer duerfen einen gepanzerten Skin haben. (setze ID auf null)");
		b.setUnvalid();		
	}

	@Override
	public void vonBeschuetzerGetragen(ANBeschuetzer b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonSchwerArbeiterGetragen(ANSchwerarbeiter s) {
		// TODO Auto-generated method stub
		
	}

}
