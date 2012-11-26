
public class HochfesterSkin extends Skin {
	public void vonBedienerGetragen(Bediener b)
	{
		System.out.println("! Bediener brauchen eine beruehrungssensitive Skin. (setze ID auf null)");
		b.setUnvalid();
	}
	
	public void vonSchwerarbeiterGetragen(Schwerarbeiter s)
	{
		System.out.println("OK - skin");
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
