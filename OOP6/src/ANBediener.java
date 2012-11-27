public abstract class ANBediener extends ANAndroide {

	public ANBediener(Integer ID) {
		super(ID);
		installer.put(SWSecurityLevel.LEVEL1, new SWInstaller());
		installer.put(SWSecurityLevel.LEVEL2, new SWInstaller());
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonBedienerGetragen(this);
	}
}
