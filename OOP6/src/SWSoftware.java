public abstract class SWSoftware {
	protected SWSecurityLevel securityLevel;

	public SWSoftware(SWSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public SWSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void installSoftwareOnBauarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnGesellschafter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnHilfskraft(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnKaempfer(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnLeibwaechter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnObjektbewacher(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnServicetechniker(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}

	public void installSoftwareOnTransportarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		androide.setInvalid();
	}
}
