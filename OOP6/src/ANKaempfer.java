import java.util.Map;

public class ANKaempfer extends ANBeschuetzer {

	public ANKaempfer(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ = "Kaempfer";
	}

	@Override
	protected Map<SWSecurityLevels, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevels, SWInstaller> allowedInstallers = super.getAllowedInstallers();
		allowedInstallers.put(new SWSecurityLevel4().getLevel(), new SWRejecter());
		allowedInstallers.put(new SWSecurityLevel5().getLevel(), new SWInstaller());
		return allowedInstallers;
	}

	@Override
	public void checkAktorenSet() {
		System.out.println("OK - Aktoren-Set");		
	}

}