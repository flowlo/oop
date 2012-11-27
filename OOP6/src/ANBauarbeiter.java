/**
 * Repraesentiert einen Bauarbeiter
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANBauarbeiter extends ANSchwerarbeiter {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANBauarbeiter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Bauarbeiter";
	}

	@Override
	public void checkSoftware() {
		software.installedOnBauarbeiter(this);
	}

}
