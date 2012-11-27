import java.util.Map;

public class ANGesellschafter extends ANBediener {

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
