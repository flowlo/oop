import java.util.HashMap;
import java.util.Map;

public abstract class ANBeschuetzer extends ANAndroide {

	public ANBeschuetzer(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonBeschuetzerGetragen(this);
	}

	@Override
	public void checkHauptTyp(ANAndroide a)
	{
		a.checkHauptTypFromBeschuetzer();
	}

	@Override
	protected void checkHauptTypFromBediener()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();

	}

	@Override
	protected void checkHauptTypFromSchwerarbeiter()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
	}

	@Override
	protected void checkHauptTypFromBeschuetzer()
	{
		System.out.println("OK - Haupttyp unveraendert");
	}

	@Override
	protected Map<SWSecurityLevel, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevel, SWInstaller> allowedInstallers = new HashMap<SWSecurityLevel, SWInstaller>();
		allowedInstallers.put(SWSecurityLevel.LEVEL4, new SWInstaller());
		return allowedInstallers;
	}
}
