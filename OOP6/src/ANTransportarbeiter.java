public class ANTransportarbeiter extends ANSchwerarbeiter {

	public ANTransportarbeiter(Integer ID) {
		super(ID);
		typ="Transportarbeiter";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnTransportarbeiter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
