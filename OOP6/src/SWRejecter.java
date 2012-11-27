public class SWRejecter extends SWInstaller {

	@Override
	public void install(ANAndroide androide, SWSoftwareStorage softwareStorage, SWSoftware software, SWSecurityLevel securityLevel) {
		// Do nothing
	}

	@Override
	public void validateAndroide(ANAndroide androide) {
		androide.setInvalid();
	}

}
