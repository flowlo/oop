@Authors(Author.Dominik)
public class BiogasTraktor extends Traktor {

	@Authors(Author.Dominik)
	public BiogasTraktor(int nummer, Einsatzzweck einsatzzweck) {
		super(nummer, einsatzzweck);
	}

	@Authors(Author.Dominik)
	public double getBisherigerVerbrauch() {
		return bisherigerVerbrauch.doubleValue();
	}

	@Authors(Author.Dominik)
	public void erhoeheVerbrauch(double biogas) {
		bisherigerVerbrauch = bisherigerVerbrauch.doubleValue() + biogas;
	}
}
