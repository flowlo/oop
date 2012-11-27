public class SWLeibwaechterSoftware extends SWSoftware {
	public SWLeibwaechterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnLeibwaechter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
