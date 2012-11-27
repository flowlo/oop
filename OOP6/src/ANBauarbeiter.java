public class ANBauarbeiter extends ANSchwerarbeiter {

	public ANBauarbeiter(Integer ID) {
		super(ID);
		typ="Bauarbeiter";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnBauarbeiter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
