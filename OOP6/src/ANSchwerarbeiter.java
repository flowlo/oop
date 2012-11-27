import java.util.HashMap;
import java.util.Map;

public abstract class ANSchwerarbeiter extends ANAndroide {

	public ANSchwerarbeiter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ = "Schwerarbeiter";
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
	protected Map<SWSecurityLevels, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevels, SWInstaller> allowedInstallers = new HashMap<SWSecurityLevels, SWInstaller>();
		allowedInstallers.put(new SWSecurityLevel3().getLevel(), new SWInstaller());
		allowedInstallers.put(new SWSecurityLevel4().getLevel(), new SWInstaller());
		return allowedInstallers;
	}
	
	public void checkAktorenSet()
	{
		System.out.println("NOCH NICHT IMPLEMENTIERT - SOFTWARE ABHAENGIG");
	}
}
