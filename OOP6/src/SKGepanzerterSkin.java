/**
 * Repraesentiert einen gepanzerten Skin eines Androiden
 * 
 * Zusicherungen:
 * * Darf nur von Beschuetzern getragen werden
 * 
 * @author Simon
 * 
 */
public class SKGepanzerterSkin extends SKSkin {

	@Override
	public void vonBedienerGetragen(ANBediener b) {
		System.out.println("! Nur Beschuetzer duerfen einen gepanzerten Skin haben. (setze ID auf null)");
		b.setInvalid();
	}

	@Override
	public void vonBeschuetzerGetragen(ANBeschuetzer b) {
		System.out.println("OK - skin");
	}

	@Override
	public void vonSchwerarbeiterGetragen(ANSchwerarbeiter s) {
		System.out.println("! Nur Beschuetzer duerfen einen gepanzerten Skin haben. (setze ID auf null)");
		s.setInvalid();
	}

	@Override
	public String toString()
	{
		return "gepanzert";
	}

}
