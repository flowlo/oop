import java.util.HashMap;
import java.util.Map;

public abstract class ANSchwerarbeiter extends ANAndroide {

	public ANSchwerarbeiter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		installer.put(SWSecurityLevel.LEVEL3, new SWInstaller());
		installer.put(SWSecurityLevel.LEVEL4, new SWInstaller());
		typ="Schwerarbeiter";
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonSchwerArbeiterGetragen(this);
	}

	@Override
	public void checkHauptTyp(ANAndroide a)
	{
		a.checkHauptTypFromSchwerarbeiter();
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
		System.out.println("OK - Haupttyp unveraendert");
	}

	@Override
	protected void checkHauptTypFromBeschuetzer()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
	}

	@Override
	protected Map<SWSecurityLevel, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevel, SWInstaller> allowedInstallers = new HashMap<SWSecurityLevel, SWInstaller>();
		allowedInstallers.put(SWSecurityLevel.LEVEL3, new SWInstaller());
		allowedInstallers.put(SWSecurityLevel.LEVEL4, new SWInstaller());
		return allowedInstallers;
	}
}
