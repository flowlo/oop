/**
 * Repraesentiert einen Leibwaechter
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
