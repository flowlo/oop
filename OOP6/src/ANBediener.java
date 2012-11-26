
public abstract class ANBediener extends ANAndroide{

		
	public void setSkin(SKSkin skin)
	{
		this.skin=skin;
	}
	
	public void checkSkin()
	{
		skin.vonBedienerGetragen(this);
	}
}
