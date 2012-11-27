/**
 * Repraesentiert einen hochfesten Skin eines Androiden
 * 
 * @author Simon
 * 
 */
public class SKHochfesterSkin extends SKSkin {
	@Override
	public void vonBedienerGetragen(ANBediener b)
	{
		System.out.println("! Bediener brauchen eine beruehrungssensitive Skin. (setze ID auf null)");
		b.setInvalid();
	}

	@Override
	public void vonBeschuetzerGetragen(ANBeschuetzer b) {
		System.out.println("OK - skin");
	}

	@Override
	public void vonSchwerarbeiterGetragen(ANSchwerarbeiter s) {
		System.out.println("OK - skin");
	}

	@Override
	public String toString()
	{
		return "hochfest";
	}
}
