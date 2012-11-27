public class SWGesellschafterSoftware extends SWBedienerSoftware {
	public SWGesellschafterSoftware(SWSecurityLevel securityLevel) {
		super(securityLevel);
	}

	@Override
	public void installSoftwareOnGesellschafter(ANAndroide androide, SWSoftwareStorage softwareStorage, SWInstaller installer) {
		installer.install(androide, softwareStorage, this, securityLevel);
	}
}
