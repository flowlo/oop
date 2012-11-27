public abstract class SWSoftware {
	protected SWSecurityLevel securityLevel;

	public SWSoftware(SWSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public SWSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void installedOnBauarbeiter(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnGesellschafter(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnHilfskraft(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnKaempfer(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnLeibwaechter(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnObjektbewacher(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnServicetechniker(ANAndroide androide) {
		androide.setInvalid();
	}

	public void installedOnTransportarbeiter(ANAndroide androide) {
		androide.setInvalid();
	}
}
