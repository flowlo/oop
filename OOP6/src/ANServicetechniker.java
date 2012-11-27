/**
 * Repraesentiert einen Servicetechniker
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANServicetechniker extends ANSchwerarbeiter {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANServicetechniker(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Servicetechniker";
	}

	@Override
	public void checkSoftware() {
		software.installedOnServicetechniker(this);
	}

}
