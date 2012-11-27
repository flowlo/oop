public abstract class ANBeschuetzer extends ANAndroide {

	public ANBeschuetzer(Integer ID) {
		super(ID);
		installer.put(SWSecurityLevel.LEVEL4, new SWInstaller());
	}

	@Override
	public void checkSkin()
	{
		getSkin().vonBeschuetzerGetragen(this);
	}
}
