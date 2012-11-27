public class ANServicetechniker extends ANSchwerarbeiter {

	public ANServicetechniker(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Servicetechniker";
	}

	@Override
	public void checkSoftware() {
		software.installedOnServicetechniker(this);
	}

}
