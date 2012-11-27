import java.util.Map;

public class ANKaempfer extends ANBeschuetzer {

	public ANKaempfer(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Kaempfer";
	}

	@Override
	protected Map<SWSecurityLevels, SWValidator> getAllowedInstallers() {
		Map<SWSecurityLevels, SWValidator> allowedInstallers = super.getAllowedInstallers();
		allowedInstallers.put(new SWSecurityLevel4().getLevel(), new SWRejecter());
		allowedInstallers.put(new SWSecurityLevel5().getLevel(), new SWValidator());
		return allowedInstallers;
	}

	@Override
	public void checkAktorenSet() {
		System.out.println("OK - Aktoren-Set");
	}

	@Override
	public void checkSoftware() {
		software.installedOnKaempfer(this);
	}

}