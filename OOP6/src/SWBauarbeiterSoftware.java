public class SWBauarbeiterSoftware extends SWSchwerarbeiterSoftware {
	public SWBauarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnBauarbeiter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
