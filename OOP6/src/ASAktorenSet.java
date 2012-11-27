
public abstract class ASAktorenSet {

	protected final float leistung;
	
	public ASAktorenSet(float leistung)
	{
		this.leistung=leistung;
	}
	
	public String toString()
	{
		return new String(leistung+"kW");
	}
	
	public abstract void vonBedienerVerwendet(ANAndroide a);
	public abstract void vonSoftwareStufe3Verwendet(ANAndroide a);
	public abstract void vonSoftwareStufe4Verwendet(ANAndroide a);
	
}
