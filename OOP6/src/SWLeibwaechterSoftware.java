public class SWLeibwaechterSoftware extends SWSoftware {
	public SWLeibwaechterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnLeibwaechter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
