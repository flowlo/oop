@Authors(Author.Dominik)
public class Duengen extends Einsatzzweck {

	@Authors(Author.Dominik)
	protected Duengen(double fassungskapazitaet) {
		super(fassungskapazitaet);
	}

	@Authors(Author.Dominik)
	public double getFassungskapazitaet() {
		return menge.doubleValue();
	}
}
