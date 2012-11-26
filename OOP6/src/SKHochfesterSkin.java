
public class SKHochfesterSkin extends SKSkin {
	public void vonBedienerGetragen(ANBediener b)
	{
		System.out.println("! Bediener brauchen eine beruehrungssensitive Skin. (setze ID auf null)");
		b.setUnvalid();
	}
	
	public void vonSchwerarbeiterGetragen(ANSchwerarbeiter s)
	{
		System.out.println("OK - skin");
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
