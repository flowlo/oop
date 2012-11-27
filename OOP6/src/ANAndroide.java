public abstract class ANAndroide {
	private SKSkin skin;
	private SWSoftware software;
	private Integer ID;

	
	public ANAndroide(Integer ID)
	{
		this.ID=ID;
	}
	
	public void setSkin(SKSkin skin)
	{
		this.skin=skin;
	}
	
	public SKSkin getSkin()
	{
		return skin;
	}
	
	
	
	public Integer getID()
	{
		return ID;
	}
	
	public void setUnvalid()
	{
		this.ID = null;
	}

	/**
	 * prüft, ob der angelegte Skin der Androiden-Verordnung entspricht
	 */
	public abstract void checkSkin();
	
	
	public String toString()
	{
		return new String("ID-"+ID+"; Skin-"+skin);
	}
}
