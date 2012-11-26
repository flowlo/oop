public abstract class ANAndroide {
	protected SKSkin skin;
	protected SWSoftware software;
	protected Integer ID;

	public void setSkin(SKSkin skin)
	{
		this.skin=skin;
	}
	
	public void setUnvalid()
	{
		this.ID = null;
	}

	/**
	 * prüft, ob der angelegte Skin der Androiden-Verordnung entspricht
	 */
	public abstract void checkSkin();
}
