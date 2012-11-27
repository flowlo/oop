public class SWObjektbewacherSoftware extends SWSoftware {
	public SWObjektbewacherSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installedOnObjektbewacher(ANAndroide androide) {
		System.out.println("OK - Passende Software fuer diesen Typ");
	}
}
