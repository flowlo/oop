
public abstract class ANBediener extends ANAndroide{

		

	
	public ANBediener(Integer ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}

	public void checkSkin()
	{
		getSkin().vonBedienerGetragen(this);
	}
}
