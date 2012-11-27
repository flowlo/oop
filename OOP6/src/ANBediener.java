import java.util.HashMap;
import java.util.Map;

/**
 * Repraesentiert einen Bediener
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public abstract class ANBediener extends ANAndroide {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANBediener(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonBedienerGetragen(this);
	}

	@Override
	public void checkAktorenSet()
	{
		getAktoren().vonBedienerVerwendet(this);
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
	protected Map<SWSecurityLevels, SWValidator> getAllowedInstallers() {
		Map<SWSecurityLevels, SWValidator> allowedInstallers = new HashMap<SWSecurityLevels, SWValidator>();
		allowedInstallers.put(new SWSecurityLevel1().getLevel(), new SWValidator());
		allowedInstallers.put(new SWSecurityLevel2().getLevel(), new SWValidator());
		return allowedInstallers;
	}

}
