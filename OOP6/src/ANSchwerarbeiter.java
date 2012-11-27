public abstract class ANSchwerarbeiter extends ANAndroide {

	public ANSchwerarbeiter(Integer ID) {
		super(ID);
		installer.put(SWSecurityLevel.LEVEL3, new SWInstaller());
		installer.put(SWSecurityLevel.LEVEL4, new SWInstaller());
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonSchwerArbeiterGetragen(this);
	}
}
