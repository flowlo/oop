public class SWServicetechnikerSoftware extends SWSchwerarbeiterSoftware {
	public SWServicetechnikerSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnServicetechniker(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
