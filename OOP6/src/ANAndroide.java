import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Repraesentiert einen Androiden
 * 
 * Zusicherungen:
 * * Die Seriennummer darf sich nicht aendern
 * * Der Haupttyp darf sich bei gleichbleibender Seriennummer nicht aendern
 * * Die Sicherheitsstufe der Software darf sich nicht aendern
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public abstract class ANAndroide {
	private SKSkin skin;
	private ASAktorenSet aktoren;
	protected SWSoftware software;
	private Integer seriennummer, checkedSeriennummer;
	protected Map<SWSecurityLevels, SWValidator> installer = new HashMap<SWSecurityLevels, SWValidator>();
	private ArrayList<String> history = new ArrayList<String>();
	protected String typ = "Androide";

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANAndroide(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren)
	{
		this.seriennummer = ID;
		installer.put(new SWSecurityLevel1().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel2().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel3().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel4().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel5().getLevel(), new SWRejecter());
		installer.putAll(getAllowedInstallers());
		this.skin = skin;
		this.software = software;
		limitSecurityLevel(software.getSecurityLevel());
		this.aktoren = aktoren;
	}

	/**
	 * Prueft, ob das Aktorenset des Androiden getragen werden kann
	 */
	public abstract void checkAktorenSet();

	/**
	 * Prueft, ob die Haupttypen des Androiden uebereinstimmen
	 * 
	 * @param androide
	 *            Der zu vergleichende Androide
	 */
	public abstract void checkHauptTyp(ANAndroide androide);

	protected abstract void checkHauptTypFromBediener();

	protected abstract void checkHauptTypFromSchwerarbeiter();

	protected abstract void checkHauptTypFromBeschuetzer();

	/**
	 * Prueft, ob die Sicherheitsstufen der Softwares uebereinstimmen
	 * 
	 * @param securityLevel
	 */
	public void checkSoftwareSecurityLevel(SWSecurityLevel securityLevel) {
		installer.get(securityLevel.getLevel()).validateAndroide(this);
	}

	/**
	 * Prueft, ob die Software des Androiden zu dessen Typ passt
	 */
	public abstract void checkSoftware();

	/**
	 * Gibt den Skin des Androiden zurueck
	 * 
	 * @return der Skin
	 */
	public SKSkin getSkin()
	{
		return skin;
	}

	/**
	 * Gibt die ID des Androiden zurueck
	 * 
	 * @return die ID
	 */
	public Integer getSeriennummer()
	{
		return seriennummer;
	}

	/**
	 * Gibt die Aktoren des Androiden zurueck
	 * 
	 * @return die Aktoren
	 */
	public ASAktorenSet getAktoren() {
		return aktoren;
	}

	/**
	 * Gibt die Software des Androiden zurueck
	 * 
	 * @return die Software
	 */
	public SWSoftware getSoftware() {
		return software;
	}

	/**
	 * Setzt die ID des Androiden auf null (invalid)
	 */
	public void setInvalid()
	{
		this.checkedSeriennummer = null;
	}

	/**
	 * prueft, ob der angelegte Skin der Androiden-Verordnung entspricht
	 */
	public abstract void checkSkin();

	@Override
	public String toString()
	{
		return new String("ID-" + seriennummer + "; Typ-" + typ + "; Skin-" + skin + "; Software-" + software + "; Aktoren-" + aktoren);
	}

	/**
	 * Limitiert die moeglichen Sicherheitsstufen der Software auf eine
	 * 
	 * @param securityLevel
	 *            die neue einzige Sicherheitsstufe fuer die Software des Androiden
	 */
	public void limitSecurityLevel(SWSecurityLevel securityLevel) {
		installer.put(new SWSecurityLevel1().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel2().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel3().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel4().getLevel(), new SWRejecter());
		installer.put(new SWSecurityLevel5().getLevel(), new SWRejecter());

		installer.put(securityLevel.getLevel(), new SWValidator());
	}

	/**
	 * Gibt die Sicherheitsstufe der Software zurueck
	 * 
	 * @return die Sicherheitsstufe der Software
	 */
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
	 * @param androide
	 */
	protected void addToHistory(ANAndroide androide)
	{
		history.add(androide.toString());
	}

	/**
	 * Kopiert die History des uebergebenen Androiden und fuegt die eigene Konfiguration dazu.
	 * 
	 * @param androide
	 *            alte History
	 */
	protected void copyHistory(ANAndroide androide)
	{
		this.history = new ArrayList<String>();
		this.history.addAll(androide.history);
		this.addToHistory(this);
	}

	/**
	 * Gibt die Aenderungen des Androiden zurueck
	 */
	public void printHistory()
	{
		StringBuilder sb = new StringBuilder("History of " + seriennummer + ":" + System.getProperty("line.separator"));
		for (String it : history)
		{
			sb.append(it);
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb.toString());
	}

	public Integer getCheckedSeriennummer(ANAndroide androide, ANAndroide old) {
		checkedSeriennummer = seriennummer;
		androide.checkSkin();
		androide.checkAktorenSet();
		old.checkHauptTyp(androide);
		androide.checkSoftware();
		androide.checkSoftwareSecurityLevel(old.getSecurityLevel());
		return checkedSeriennummer;
	}
}
