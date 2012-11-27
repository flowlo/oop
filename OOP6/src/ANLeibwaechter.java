public class ANLeibwaechter extends ANBeschuetzer {

	public ANLeibwaechter(Integer ID) {
		super(ID);
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnLeibwaechter(null, softwareStorage, installer.get(softwareStorage.getSoftware().getSecurityLevel()));
	}

}
