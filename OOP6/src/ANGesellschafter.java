import java.util.Map;

public class ANGesellschafter extends ANBediener {

	public ANGesellschafter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ="Gesellschafter";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnGesellschafter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

	@Override
	protected Map<SWSecurityLevel, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevel, SWInstaller> allowedInstallers = super.getAllowedInstallers();
		allowedInstallers.put(SWSecurityLevel.LEVEL2, new SWRejecter());
		return allowedInstallers;
	}

}
