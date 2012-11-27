public class ANHilfskraft extends ANBediener {

	public ANHilfskraft(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Hilfskraft";
	}

	@Override
	public void checkSoftware() {
		software.installedOnHilfskraft(this);
	}

}
