
public class SKSensitiveSkin extends SKSkin {
	public void vonBedienerGetragen(ANBediener b)
	{
		System.out.println("OK - skin");
	}

	@Override
	public void vonBeschuetzerGetragen(ANBeschuetzer b) {
		System.out.println("OK - skin");
	}

	@Override
	public void vonSchwerArbeiterGetragen(ANSchwerarbeiter s) {
		System.out.println("OK - skin");
	}
}
