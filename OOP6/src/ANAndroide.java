import java.util.HashMap;
import java.util.Map;

public abstract class ANAndroide {
	private SKSkin skin;
	protected SWSoftwareStorage softwareStorage;
	private Integer ID;
	protected Map<SWSecurityLevel, SWInstaller> installer = new HashMap<SWSecurityLevel, SWInstaller>();

	public ANAndroide(Integer ID)
	{
		this.ID = ID;
		softwareStorage = new SWSoftwareStorage();
		installer.put(SWSecurityLevel.LEVEL1, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL2, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL3, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL4, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL5, new SWRejecter());
	}

	public abstract void checkHauptTyp(ANAndroide a);

	public abstract void checkHauptTypFromBediener();

	public abstract void checkHauptTypFromSchwerarbeiter();

	public abstract void checkHauptTypFromBeschuetzer();

	public void checkSoftwareLevel(SWSecurityLevel securityLevel) {
		installer.get(securityLevel).validateAndroide(this);
	}

	public void setSkin(SKSkin skin)
	{
		this.skin = skin;
	}

	public SKSkin getSkin()
	{
		return skin;
	}

	public Integer getID()
	{
		return ID;
	}

	public void setInvalid()
	{
		this.ID = null;
	}

	/**
	 * prueft, ob der angelegte Skin der Androiden-Verordnung entspricht
	 */
	public abstract void checkSkin();

	@Override
	public String toString()
	{
		return new String("ID-" + ID + "; Skin-" + skin + "; Software-" + softwareStorage.getSoftware());
	}

	public abstract void installSoftware(SWSoftware software);

	public void limitSecurityLevel(SWSecurityLevel securityLevel) {
		installer.put(SWSecurityLevel.LEVEL1, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL2, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL3, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL4, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL5, new SWRejecter());

		installer.put(securityLevel, new SWInstaller());
	}

}
