public class SWInstaller {

	public void install(ANAndroide androide, SWSoftwareStorage softwareStorage, SWSoftware software, SWSecurityLevel securityLevel) {
		softwareStorage.setSoftware(software);
		androide.limitSecurityLevel(securityLevel);
	}

	public void validateAndroide(ANAndroide androide) {
		// Do nothing
	}

}
