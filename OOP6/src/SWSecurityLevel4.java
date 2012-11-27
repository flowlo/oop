/**
 * Repraesentiert die Sicherheitsstufe 4 einer Software
 * 
 * @author Dominik
 * 
 */
public class SWSecurityLevel4 extends SWSecurityLevel {
	@Override
	public SWSecurityLevels getLevel() {
		return SWSecurityLevels.LEVEL4;
	}

	@Override
	public void vonSoftwareStufe4Verwendet(ANAndroide androide) {
		androide.getAktoren().vonSoftwareStufe4Verwendet(androide);
	}
}
