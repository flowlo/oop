/**
 * Repraesentiert einen sensitiven Skin eines Androiden
 * 
 * @author Simon
 * 
 */
public class SKSensitiveSkin extends SKSkin {
	@Override
	public void vonBedienerGetragen(ANBediener b)
	{
		System.out.println("OK - skin");
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
		return "sensitve";
	}
}
