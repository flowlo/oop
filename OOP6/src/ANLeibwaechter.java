public class ANLeibwaechter extends ANBeschuetzer {

	public ANLeibwaechter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ="Leibwaechter";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnLeibwaechter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

	@Override
	public void checkAktorenSet() {
		getAktoren().vonSoftwareStufe4Verwendet(this);
		
	}

}
