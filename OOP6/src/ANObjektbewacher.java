public class ANObjektbewacher extends ANBeschuetzer {

	public ANObjektbewacher(Integer ID) {
		super(ID);
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnObjektbewacher(null, softwareStorage, installer.get(softwareStorage.getSoftware().getSecurityLevel()));
	}

}
