public class ANBauarbeiter extends ANSchwerarbeiter {

	public ANBauarbeiter(Integer ID) {
		super(ID);
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnBauarbeiter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
