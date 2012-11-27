public class ANLeibwaechter extends ANBeschuetzer {

	public ANLeibwaechter(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ = "Leibwaechter";
	}

	@Override
	public void checkAktorenSet() {
		getAktoren().vonSoftwareStufe4Verwendet(this);
		
	}

}
