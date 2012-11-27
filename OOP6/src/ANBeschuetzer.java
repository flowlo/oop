public abstract class ANBeschuetzer extends ANAndroide {

	public ANBeschuetzer(Integer ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}

	public void checkSkin()
	{
		getSkin().vonBeschuetzerGetragen(this);
	}
}
