/**
 * Repraesentiert einen Leibwaechter
 * 
 * Zusicherungen:
 * * Muss eine Leibwaechtersoftware installiert haben
 * * Darf nur Software der Sicherheitsstufe 4 installiert haben
 * * Aktoren duerfen eine Leistung von 10 kW nicht ueberschreiten
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANLeibwaechter extends ANBeschuetzer {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANLeibwaechter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Leibwaechter";
	}

	@Override
	public void checkAktorenSet() {
		software.getSecurityLevel().vonSoftwareStufe4Verwendet(this);
	}

	@Override
	public void checkSoftware() {
		software.installedOnLeibwaechter(this);
	}

}
