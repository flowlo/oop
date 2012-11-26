
public class HochfesterSkin extends Skin {
	public void vonBedienerGetragen(Bediener b)
	{
		System.out.println("! Bediener brauchen eine beruerungssensitive Skin. (setze ID auf null)");
		b.setUnvalid();
	}
}
