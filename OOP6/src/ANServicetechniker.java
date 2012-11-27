public class ANServicetechniker extends ANSchwerarbeiter { //commit

	public ANServicetechniker(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ = "Servicetechniker";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnServicetechniker(this, softwareStorage, installer.get(software.getSecurityLevel()));
	}

}
