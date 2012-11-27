/**
 * Repraesentiert richtig awesome Aktoren
 * 
 * @author Dominik
 * @author Simon
 * 
 */
public class ASAwesomeAktoren extends ASAktorenSet {

	/**
	 * Konstruktor
	 */
	public ASAwesomeAktoren()
	{
		super(50);
	}

	@Override
	public void vonBedienerVerwendet(ANAndroide a) {
		System.out.println("! Aktoren-Set zu stark fuer diesen Androiden.");
		a.setInvalid();
	}

	@Override
	public void vonSoftwareStufe3Verwendet(ANAndroide a) {
		System.out.println("! Aktoren-Set zu stark fuer diesen Androiden.");
		a.setInvalid();
	}

	@Override
	public void vonSoftwareStufe4Verwendet(ANAndroide a) {
		System.out.println("! Aktoren-Set zu stark fuer diesen Androiden.");
		a.setInvalid();
	}

}
