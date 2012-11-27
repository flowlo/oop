public class SWKaempferSoftware extends SWSoftware {
	public SWKaempferSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnKaempfer(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
