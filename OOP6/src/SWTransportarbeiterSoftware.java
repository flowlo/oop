public class SWTransportarbeiterSoftware extends SWSchwerarbeiterSoftware {
	public SWTransportarbeiterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnTransportarbeiter(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
