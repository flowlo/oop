
public abstract class Androide {
	protected Skin skin;
	protected String software;
	protected Integer ID;
	
	public void setUnvalid()
	{
		this.ID=null;
	}
	
	/**
	 * pr�ft, ob der angelegte Skin der Androiden-Verordnung entspricht
	 */
	public abstract void checkSkin();
}
