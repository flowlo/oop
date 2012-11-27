public class SWRejecter extends SWInstaller {

	@Override
	public void install(ANAndroide androide, SWSoftwareStorage softwareStorage, SWSoftware software, SWSecurityLevel securityLevel) {
		androide.setInvalid();
	}

	@Override
	public void validateAndroide(ANAndroide androide) {
		androide.setInvalid();
	}

}
