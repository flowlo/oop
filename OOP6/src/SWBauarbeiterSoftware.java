public class SWBauarbeiterSoftware extends SWSchwerarbeiterSoftware {
	public SWBauarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnBauarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
