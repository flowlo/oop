public class SWHilfskraftSoftware extends SWBedienerSoftware {
	public SWHilfskraftSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnBauarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}

	@Override
	public void installSoftwareOnGesellschafter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}

	@Override
	public void installSoftwareOnHilfskraft(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, softwareStorage.getSoftware().getSecurityLevel());
	}

	@Override
	public void installSoftwareOnKaempfer(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}

	@Override
	public void installSoftwareOnLeibwaechter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}

	@Override
	public void installSoftwareOnObjektbewacher(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}

	@Override
	public void installSoftwareOnServicetechniker(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}

	@Override
	public void installSoftwareOnTransportarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
	}
}