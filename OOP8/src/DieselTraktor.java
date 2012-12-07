@Authors(Author.Dominik)
public class DieselTraktor extends Traktor {

	@Authors(Author.Dominik)
	public DieselTraktor(int nummer, Einsatzzweck einsatzzweck) {
		super(nummer, einsatzzweck);
	}

	@Authors(Author.Dominik)
	public Integer getBisherigerVerbrauch() {
		return bisherigerVerbrauch.intValue();
	}

	@Authors(Author.Dominik)
	public void erhoeheVerbrauch(int diesel) {
		bisherigerVerbrauch = bisherigerVerbrauch.intValue() + diesel;
	}
}
