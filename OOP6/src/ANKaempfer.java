import java.util.Map;

public class ANKaempfer extends ANBeschuetzer {

	public ANKaempfer(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		installer.put(SWSecurityLevel.LEVEL4, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL5, new SWInstaller());
		typ="Kaempfer";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnKaempfer(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

	@Override
	protected Map<SWSecurityLevel, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevel, SWInstaller> allowedInstallers = super.getAllowedInstallers();
		allowedInstallers.put(SWSecurityLevel.LEVEL4, new SWRejecter());
		allowedInstallers.put(SWSecurityLevel.LEVEL5, new SWInstaller());
		return allowedInstallers;
	}

	@Override
	public void checkAktorenSet() {
		System.out.println("OK - Aktoren-Set");		
	}

}