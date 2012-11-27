public abstract class ANSchwerarbeiter extends ANAndroide {

	
	public ANSchwerarbeiter(Integer ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}

	public void checkSkin()
	{
		getSkin().vonSchwerArbeiterGetragen(this);
	}
}
