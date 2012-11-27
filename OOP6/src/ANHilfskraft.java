public class ANHilfskraft extends ANBediener {

	public ANHilfskraft(Integer ID) {
		super(ID);
		typ="Hilfskraft";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnHilfskraft(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
