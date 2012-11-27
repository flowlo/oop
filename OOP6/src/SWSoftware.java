public abstract class SWSoftware {
	protected SWSecurityLevel securityLevel;

	public SWSoftware(SWSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public SWSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public abstract void installSoftwareOnBauarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnGesellschafter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnHilfskraft(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnKaempfer(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnLeibwaechter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnObjektbewacher(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnServicetechniker(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);

	public abstract void installSoftwareOnTransportarbeiter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer);
}
