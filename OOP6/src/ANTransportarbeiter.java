/**
 * Repraesentiert einen Transportarbeiter
 * 
 * Zusicherungen:
 * * Muss eine Transportarbeitersoftware installiert haben
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANTransportarbeiter extends ANSchwerarbeiter {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANTransportarbeiter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Transportarbeiter";
	}

	@Override
	public void checkSoftware() {
		software.installedOnTransportarbeiter(this);
	}

}
