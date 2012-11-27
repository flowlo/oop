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

	@Override
	public void checkHauptTyp(ANAndroide a)
	{
		a.checkHauptTypFromSchwerarbeiter();
	}

	@Override
	protected void checkHauptTypFromBediener()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
	}

	@Override
	protected void checkHauptTypFromSchwerarbeiter()
	{
		System.out.println("OK - Haupttyp unveraendert");
	}

	@Override
	protected void checkHauptTypFromBeschuetzer()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
	}
}
