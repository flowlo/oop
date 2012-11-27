public class ANTransportarbeiter extends ANSchwerarbeiter {

	public ANTransportarbeiter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Transportarbeiter";
	}

	@Override
	public void checkSoftware() {
		software.installedOnTransportarbeiter(this);
	}

}
