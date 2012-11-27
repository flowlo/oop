/**
 * Repraesentiert die Sicherheitsstufe 3 einer Software
 * 
 * @author Dominik
 * 
 */
public class SWSecurityLevel3 extends SWSecurityLevel {
	@Override
	public SWSecurityLevels getLevel() {
		return SWSecurityLevels.LEVEL3;
	}

	@Override
	public void vonSoftwareStufe3Verwendet(ANAndroide androide) {
		androide.getAktoren().vonSoftwareStufe3Verwendet(androide);
	}
}
