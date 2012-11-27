import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ANAndroide {
	private SKSkin skin;
	private ASAktorenSet aktoren;
	protected SWSoftware software;
	private Integer ID;
	protected Map<SWSecurityLevels, SWValidator> installer = new HashMap<SWSecurityLevels, SWValidator>();
	private ArrayList<String> history = new ArrayList<String>();
	protected String typ = "Androide";

	public ANAndroide(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren)
	{
		this.ID = ID;
		installer.put(new SWSecurityLevel1().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel2().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel3().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel4().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel5().getLevel(), new SWRejecter());
		installer.putAll(getAllowedInstallers());
		setSkin(skin);
		installSoftware(software);
		setAktoren(aktoren);
	}

	public abstract void checkAktorenSet();

	public abstract void checkHauptTyp(ANAndroide a);

	protected abstract void checkHauptTypFromBediener();

	protected abstract void checkHauptTypFromSchwerarbeiter();

	protected abstract void checkHauptTypFromBeschuetzer();

	public void checkSoftwareSecurityLevel(SWSecurityLevel securityLevel) {
		installer.get(securityLevel.getLevel()).validateAndroide(this);
	}

	public abstract void checkSoftware();

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

	public ASAktorenSet getAktoren() {
		return aktoren;
	}

	public void setAktoren(ASAktorenSet aktoren) {
		this.aktoren = aktoren;
	}

	public SWSoftware getSoftware() {
		return software;
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
		return new String("ID-" + ID + "; Typ-" + typ + "; Skin-" + skin + "; Software-" + software + "; Aktoren-" + aktoren);
	}

	public void installSoftware(SWSoftware software) {
		this.software = software;
		limitSecurityLevel(software.getSecurityLevel());
	}

	public void limitSecurityLevel(SWSecurityLevel securityLevel) {
		installer.put(new SWSecurityLevel1().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel2().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel3().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel4().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel5().getLevel(), new SWRejecter());

		installer.put(securityLevel.getLevel(), new SWValidator());
	}

	public SWSecurityLevel getSecurityLevel() {
		if (software == null) {
			return null;
		} else {
			return software.getSecurityLevel();
		}
	}

	protected abstract Map<SWSecurityLevels, SWValidator> getAllowedInstallers();

	/**
	 * Speichert die konfiguartion des Uebergebenen Androiden in die History.
	 * 
	 * @param a
	 */
	protected void addToHistory(ANAndroide a)
	{
		history.add(a.toString());
	}

	/**
	 * Kopiert die History des uebergebenen Androiden und fuegt die eigene Konfiguration dazu.
	 * 
	 * @param a
	 *            alte History
	 */
	protected void copyHistory(ANAndroide a)
	{
		this.history = new ArrayList<String>();
		this.history.addAll(a.history);
		this.addToHistory(this);
	}

	public void printHistory()
	{
		StringBuilder sb = new StringBuilder("History of " + ID + ":" + System.getProperty("line.separator"));
		for (String it : history)
		{
			sb.append(it);
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb.toString());
	}

}
