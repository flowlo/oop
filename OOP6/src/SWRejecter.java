public class SWRejecter extends SWValidator {

	@Override
	public void validateAndroide(ANAndroide androide) {
		androide.setInvalid();
		System.out.println("! Keine passende Software-Sicherheitsstufe fuer diesen Androiden");
	}

}
