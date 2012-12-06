@Author(Authors.Dominik)
public class DieselTraktor extends Traktor {

	public DieselTraktor(int nummer, Einsatzzweck einsatzzweck) {
		super(nummer, einsatzzweck);
	}

	public Integer getBisherigerVerbrauch() {
		return bisherigerVerbrauch.intValue();
	}

	public void erhoeheVerbrauch(int diesel) {
		bisherigerVerbrauch = bisherigerVerbrauch.intValue() + diesel;
	}

}
