@Author(Authors.Dominik)
public class BiogasTraktor extends Traktor {

	public BiogasTraktor(int nummer, Einsatzzweck einsatzzweck) {
		super(nummer, einsatzzweck);
	}

	public double getBisherigerVerbrauch() {
		return bisherigerVerbrauch.doubleValue();
	}

	public void erhoeheVerbrauch(double biogas) {
		bisherigerVerbrauch = bisherigerVerbrauch.doubleValue() + biogas;
	}

}
