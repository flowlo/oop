public class SWHilfskraftSoftware extends SWBedienerSoftware {
	public SWHilfskraftSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnHilfskraft(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
