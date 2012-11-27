/**
 * Repraesentiert die Sicherheitsstufen einer Software
 * 
 * Zusicherungen:
 * 
 * @author Dominik
 * 
 */
public abstract class SWSecurityLevel {
	/**
	 * Gibt das Sicherheitslevel einer Software zurueck
	 * 
	 * @return das Sicherheitslevel
	 */
	public abstract SWSecurityLevels getLevel();

	/**
	 * Abstrakte Methode, um die Sicherheitsstufe 1 einer Software zu ueberpruefen
	 * 
	 * @param androide
	 */
	public void vonSoftwareStufe1Verwendet(ANAndroide androide) {
	}

	/**
	 * Abstrakte Methode, um die Sicherheitsstufe 2 einer Software zu ueberpruefen
	 * 
	 * @param androide
	 */
	public void vonSoftwareStufe2Verwendet(ANAndroide androide) {
	}

	/**
	 * Abstrakte Methode, um die Sicherheitsstufe 3 einer Software zu ueberpruefen
	 * 
	 * @param androide
	 */
	public void vonSoftwareStufe3Verwendet(ANAndroide androide) {
	}

	/**
	 * Abstrakte Methode, um die Sicherheitsstufe 4 einer Software zu ueberpruefen
	 * 
	 * @param androide
	 */
	public void vonSoftwareStufe4Verwendet(ANAndroide androide) {
	}

	/**
	 * Abstrakte Methode, um die Sicherheitsstufe 5 einer Software zu ueberpruefen
	 * 
	 * @param androide
	 */
	public void vonSoftwareStufe5Verwendet(ANAndroide androide) {
	}
}
