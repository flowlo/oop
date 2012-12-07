@Authors("Dominik")
public class Duengen extends Einsatzzweck {

	@Authors("Dominik")
	protected Duengen(double fassungskapazitaet) {
		super(fassungskapazitaet);
	}

	@Authors("Dominik")
	public double getFassungskapazitaet() {
		return menge.doubleValue();
	}
}
