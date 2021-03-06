import java.util.HashMap;
import java.util.Map;

/**
 * Repraesentiert einen Schwerarbeiter
 * 
 * Zusicherungen:
 * * Darf keine gepanzerten Skins tragen
 * * Muss eine Schwerarbeitersoftware installiert haben
 * * Darf nur Software der Sicherheitsstufen 3 oder 4 installiert haben
 * * Aktoren duerfen abhaengig von der Software eine Leistung von 5 kW bzw. 10 kW nicht ueberschreiten
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public abstract class ANSchwerarbeiter extends ANAndroide {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANSchwerarbeiter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Schwerarbeiter";
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonSchwerarbeiterGetragen(this);
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
	protected Map<SWSecurityLevels, SWValidator> getAllowedInstallers() {
		Map<SWSecurityLevels, SWValidator> allowedInstallers = new HashMap<SWSecurityLevels, SWValidator>();
		allowedInstallers.put(new SWSecurityLevel3().getLevel(), new SWValidator());
		allowedInstallers.put(new SWSecurityLevel4().getLevel(), new SWValidator());
		return allowedInstallers;
	}

	@Override
	public void checkAktorenSet()
	{
		software.getSecurityLevel().vonSoftwareStufe3Verwendet(this);
		software.getSecurityLevel().vonSoftwareStufe4Verwendet(this);
	}
}
