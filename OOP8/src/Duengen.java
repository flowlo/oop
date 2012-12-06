@Author(Authors.Dominik)
public class Duengen extends Einsatzzweck {
	protected Duengen(double fassungskapazitaet) {
		super(fassungskapazitaet);
	}

	public double getFassungskapazitaet() {
		return menge.doubleValue();
	}
}
