public class ANBauarbeiter extends ANSchwerarbeiter {

	public ANBauarbeiter(Integer ID, SKSkin skin, SWSoftware software, ASAktorenSet aktoren) {
		super(ID, skin, software, aktoren);
		typ = "Bauarbeiter";
	}

	@Override
	public void checkSoftware() {
		software.installedOnBauarbeiter(this);
	}

}
