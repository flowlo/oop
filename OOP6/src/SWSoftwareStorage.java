public class SWSoftwareStorage {
	private SWSoftware software;

	public SWSoftwareStorage() {
		this.software = null;
	}

	public SWSoftwareStorage(SWSoftware software) {
		this.software = software;
	}

	public SWSoftware getSoftware() {
		return software;
	}

	public void setSoftware(SWSoftware software) {
		this.software = software;
	}
}
