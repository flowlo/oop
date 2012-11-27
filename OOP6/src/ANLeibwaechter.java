public class ANLeibwaechter extends ANBeschuetzer {

	public ANLeibwaechter(Integer ID) {
		super(ID);
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnLeibwaechter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
