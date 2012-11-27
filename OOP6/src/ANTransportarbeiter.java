public class ANTransportarbeiter extends ANSchwerarbeiter {

	public ANTransportarbeiter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ="Transportarbeiter";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnTransportarbeiter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
