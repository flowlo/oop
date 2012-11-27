public class ANObjektbewacher extends ANBeschuetzer {

	public ANObjektbewacher(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ="Objektbewacher";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnObjektbewacher(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

	@Override
	public void checkAktorenSet() {
		getAktoren().vonSoftwareStufe4Verwendet(this);		
	}

}
