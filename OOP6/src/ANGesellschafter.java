import java.util.Map;

public class ANGesellschafter extends ANBediener {

	public ANGesellschafter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ = "Gesellschafter";
	}

	@Override
	protected Map<SWSecurityLevels, SWInstaller> getAllowedInstallers() {
		Map<SWSecurityLevels, SWInstaller> allowedInstallers = super.getAllowedInstallers();
		allowedInstallers.put(new SWSecurityLevel2().getLevel(), new SWRejecter());
		return allowedInstallers;
	}

}
