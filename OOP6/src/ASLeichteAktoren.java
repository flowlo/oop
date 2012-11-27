/**
 * Repraesentiert leichte Aktoren
 * 
 * @author Dominik
 * @author Simon
 * 
 */
public class ASLeichteAktoren extends ASAktorenSet {

	/**
	 * Konstruktor
	 */
	public ASLeichteAktoren()
	{
		super(3);
	}

	@Override
	public void vonBedienerVerwendet(ANAndroide a) {
		System.out.println("! Aktoren-Set zu stark fuer diesen Androiden.");
		a.setInvalid();
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
