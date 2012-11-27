/**
 * Repraesentiert einen Gesellschafter
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANHilfskraft extends ANBediener {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANHilfskraft(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Hilfskraft";
	}

	@Override
	public void checkSoftware() {
		software.installedOnHilfskraft(this);
	}

}
