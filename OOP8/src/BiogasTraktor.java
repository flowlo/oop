@Author(Authors.Dominik)
public class BiogasTraktor extends Traktor {

	public BiogasTraktor(int nummer, Einsatzzweck einsatzzweck) {
		super(nummer, einsatzzweck);
	}

	public Float getBisherigerVerbrauch() {
		return bisherigerVerbrauch.floatValue();
	}

	public void erhoeheVerbrauch(float biogas) {
		bisherigerVerbrauch = bisherigerVerbrauch.floatValue() + biogas;
	}

}
