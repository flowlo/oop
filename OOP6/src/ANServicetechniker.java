public class ANServicetechniker extends ANSchwerarbeiter { //commit

	public ANServicetechniker(Integer ID) {
		super(ID);
		typ="Servicetechniker";
	}

	@Override
	public void installSoftware(SWSoftware software) {
		software.installSoftwareOnServicetechniker(null, softwareStorage, installer.get(softwareStorage.getSoftware().getSecurityLevel()));
	}

}
