public class ASLameAktoren extends ASAktorenSet {

	public ASLameAktoren()
	{
		super(0.5f);
	}

	@Override
	public void vonBedienerVerwendet(ANAndroide a) {
		System.out.println("OK - Aktoren-Set");
	}

	@Override
	public void vonSoftwareStufe3Verwendet(ANAndroide a) {
		System.out.println("OK - Aktoren-Set");
	}

	@Override
	public void vonSoftwareStufe4Verwendet(ANAndroide a) {
		System.out.println("OK - Aktoren-Set");
	}

}
