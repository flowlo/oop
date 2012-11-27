public class SWServicetechnikerSoftware extends SWSchwerarbeiterSoftware {
	public SWServicetechnikerSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnServicetechniker(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
