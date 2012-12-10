@Authors("Dominik")
public class BiogasTraktor extends Traktor {

	@Authors("Dominik")
	public BiogasTraktor(Einsatzzweck einsatzzweck) {
		super(einsatzzweck);
	}

	@Authors("Dominik")
	public double getBisherigerVerbrauch() {
		return bisherigerVerbrauch.doubleValue();
	}

	@Authors("Dominik")
	public void erhoeheVerbrauch(double biogas) {
		bisherigerVerbrauch = bisherigerVerbrauch.doubleValue() + biogas;
	}
}
