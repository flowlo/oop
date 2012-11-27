public class SWGesellschafterSoftware extends SWBedienerSoftware {
	public SWGesellschafterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnGesellschafter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
