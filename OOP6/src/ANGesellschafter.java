import java.util.Map;

/**
 * Repraesentiert einen Gesellschafter
 * 
 * @author Simon
 * @author Dominik
 * @author Lorenz
 * 
 */
public class ANGesellschafter extends ANBediener {

	/**
	 * Konstruktor
	 * 
	 * @param ID
	 * @param skin
	 * @param software
	 * @param aktoren
	 */
	public ANGesellschafter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Gesellschafter";
	}

	@Override
	protected Map<SWSecurityLevels, SWValidator> getAllowedInstallers() {
		Map<SWSecurityLevels, SWValidator> allowedInstallers = super.getAllowedInstallers();
		allowedInstallers.put(new SWSecurityLevel2().getLevel(), new SWRejecter());
		return allowedInstallers;
	}

	@Override
	public void checkSoftware() {
		software.installedOnGesellschafter(this);
	}

}
