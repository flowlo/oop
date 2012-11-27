public class ANKaempfer extends ANBeschuetzer {

	public ANKaempfer(Integer ID) {
		super(ID);
		installer.put(SWSecurityLevel.LEVEL4, new SWRejecter());
		installer.put(SWSecurityLevel.LEVEL5, new SWInstaller());
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnKaempfer(null, softwareStorage, installer.get(softwareStorage.getSoftware().getSecurityLevel()));
	}

}