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
	
	
	public int checkUpdateHauptTyp(ANHilfskraft old, ANHilfskraft update)
	{
		return old.getID();		
	}
	
	
	public void checkHauptTyp(ANAndroide a)
	{
		a.checkHauptTypFromBediener();
	}
	
	public void checkHauptTypFromBediener()
	{
		System.out.println("OK - Haupttyp unveraendert");
	}
	public void checkHauptTypFromSchwerarbeiter()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
		
	}
	public void checkHauptTypFromBeschuetzer()
	{
		System.out.println("! Haupttyp darf nicht veraendert werden. (setze ID auf null)");
		this.setInvalid();
	}
	
}
