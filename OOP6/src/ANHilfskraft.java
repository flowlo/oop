public class ANHilfskraft extends ANBediener {

	public ANHilfskraft(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ="Hilfskraft";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnHilfskraft(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
