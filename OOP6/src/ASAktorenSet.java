/**
 * Repraesentiert ein Aktorenset
 * 
 * @author Dominik
 * @author Simon
 * 
 */
public abstract class ASAktorenSet {

	protected final float leistung;

	/**
	 * Konstruktor
	 * 
	 * @param leistung
	 *            die Leistung des Aktorensets
	 */
	public ASAktorenSet(float leistung)
	{
		this.leistung = leistung;
	}

	@Override
	public String toString()
	{
		return new String(leistung + "kW");
	}

	/**
	 * Prueft, ob das Aktorenset von einem Bediener verwenden kann
	 * 
	 * @param androide
	 */
	public abstract void vonBedienerVerwendet(ANAndroide androide);

	/**
	 * Prueft, ob das Aktorenset mit einer Software der Sicherheitsstufe 3 getragen werden kann
	 * 
	 * @param androide
	 */
	public abstract void vonSoftwareStufe3Verwendet(ANAndroide androide);

	/**
	 * Prueft, ob das Aktorenset mit einer Software der Sicherheitsstufe 4 getragen werden kann
	 * 
	 * @param androide
	 */
	public abstract void vonSoftwareStufe4Verwendet(ANAndroide androide);

}
