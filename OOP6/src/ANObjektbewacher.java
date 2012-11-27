/**
 * Repraesentiert einen Objektbewacher
 * 
 * Zusicherungen:
 * * Muss eine Objektbewachersoftware installiert haben
 * * Darf nur Software der Sicherheitsstufe 4 installiert haben
 * * Aktoren duerfen eine Leistung von 10 kW nicht ueberschreiten
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANObjektbewacher extends ANBeschuetzer {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANObjektbewacher(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Objektbewacher";
	}

	@Override
	public void checkAktorenSet() {
		software.getSecurityLevel().vonSoftwareStufe4Verwendet(this);
	}

	@Override
	public void checkSoftware() {
		software.installedOnObjektbewacher(this);
	}

}
