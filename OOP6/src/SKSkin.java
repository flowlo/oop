/**
 * Repraesentiert den Skin eines Androiden
 * 
 * @author Simon
 * 
 */
public abstract class SKSkin {
	/**
	 * Prueft, ob der Skin von einem Bediener getragen werden kann
	 * 
	 * @param bediener
	 */
	public abstract void vonBedienerGetragen(ANBediener bediener);

	/**
	 * Prueft, ob der Skin von einem Beschuetzer getragen werden kann
	 * 
	 * @param beschuetzer
	 */
	public abstract void vonBeschuetzerGetragen(ANBeschuetzer beschuetzer);

	/**
	 * Prueft, ob der Skin von einem Schwerarbeiter getragen werden kann
	 * 
	 * @param schwerarbeiter
	 */
	public abstract void vonSchwerarbeiterGetragen(ANSchwerarbeiter schwerarbeiter);
}
