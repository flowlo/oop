public class ANObjektbewacher extends ANBeschuetzer {

	public ANObjektbewacher(Integer ID, SKSkin skin, SWSoftware software) {
		super(ID, skin, software);
		typ = "Objektbewacher";
	}

	@Override
	public void checkAktorenSet() {
		getAktoren().vonSoftwareStufe4Verwendet(this);		
	}

}
