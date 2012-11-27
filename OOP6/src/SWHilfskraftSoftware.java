public class SWHilfskraftSoftware extends SWBedienerSoftware {
	public SWHilfskraftSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnHilfskraft(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
