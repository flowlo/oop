
public class SKGepanzerterSkin extends SKSkin {

	@Override
	public void vonBedienerGetragen(ANBediener b) {
		System.out.println("! Nur Beschuetzer duerfen einen gepanzerten Skin haben. (setze ID auf null)");
		b.setUnvalid();		
	}

	@Override
	public void vonBeschuetzerGetragen(ANBeschuetzer b) {
		System.out.println("OK - skin");		
	}

	@Override
	public void vonSchwerArbeiterGetragen(ANSchwerarbeiter s) {
		System.out.println("! Nur Beschuetzer duerfen einen gepanzerten Skin haben. (setze ID auf null)");
		s.setUnvalid();	
	}

}
