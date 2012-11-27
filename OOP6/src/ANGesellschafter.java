public class ANGesellschafter extends ANBediener {

	public ANGesellschafter(Integer ID) {
		super(ID);
		installer.put(SWSecurityLevel.LEVEL2, new SWRejecter());
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnGesellschafter(null, softwareStorage, installer.get(softwareStorage.getSoftware().getSecurityLevel()));
	}

}
