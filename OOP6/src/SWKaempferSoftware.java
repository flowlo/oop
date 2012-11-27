public class SWKaempferSoftware extends SWSoftware {
	public SWKaempferSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnKaempfer(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
