public class ANHilfskraft extends ANBediener {

	public ANHilfskraft(Integer ID) {
		super(ID);
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnHilfskraft(null, softwareStorage, installer.get(softwareStorage.getSoftware().getSecurityLevel()));
	}

}
