
public abstract class Bediener extends Androide{

		
	public void setSkin(Skin skin)
	{
		this.skin=skin;
	}
	
	public void checkSkin()
	{
		skin.vonBedienerGetragen(this);
	}
}
