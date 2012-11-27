public class SWTransportarbeiterSoftware extends SWSchwerarbeiterSoftware {
	public SWTransportarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnTransportarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
