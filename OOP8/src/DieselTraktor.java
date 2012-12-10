@Authors("Dominik")
public class DieselTraktor extends Traktor {

	@Authors("Dominik")
	public DieselTraktor(Einsatzzweck einsatzzweck) {
		super(einsatzzweck);
	}

	@Authors("Dominik")
	public Integer getBisherigerVerbrauch() {
		return bisherigerVerbrauch.intValue();
	}

	@Authors("Dominik")
	public void erhoeheVerbrauch(int diesel) {
		bisherigerVerbrauch = bisherigerVerbrauch.intValue() + diesel;
	}
}
