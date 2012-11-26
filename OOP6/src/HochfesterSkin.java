
public class HochfesterSkin extends Skin {
	public void vonBedienerGetragen(Bediener b)
	{
		System.out.println("! Bediener brauchen eine beruehrungssensitive Skin. (setze ID auf null)");
		b.setUnvalid();
	}
}
