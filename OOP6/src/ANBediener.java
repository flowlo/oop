import java.util.HashMap;
import java.util.Map;

public abstract class ANBediener extends ANAndroide {

	public ANBediener(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonBedienerGetragen(this);
	}
	
	public void checkAktorenSet()
	{
		getAktoren().vonBedienerVerwendet(this);
	}

	public int checkUpdateHauptTyp(ANHilfskraft old, ANHilfskraft update)
	{
		return old.getID();
	}

	@Override
	public void checkHauptTyp(ANAndroide a)
	{
		a.checkHauptTypFromBediener();
	}

	@Override
	protected void checkHauptTypFromBediener()
	{
		System.out.println("OK - Haupttyp unveraendert");
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
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
	}

	@Override
	protected Map<SWSecurityLevel, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevel, SWInstaller> allowedInstallers = new HashMap<SWSecurityLevel, SWInstaller>();
		allowedInstallers.put(SWSecurityLevel.LEVEL1, new SWInstaller());
		allowedInstallers.put(SWSecurityLevel.LEVEL2, new SWInstaller());
		return allowedInstallers;
	}

}
