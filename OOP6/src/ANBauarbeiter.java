public class ANBauarbeiter extends ANSchwerarbeiter {

	public ANBauarbeiter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ="Bauarbeiter";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnBauarbeiter(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
