@Author(Authors.Dominik)
public class Duengen extends Einsatzzweck {
	protected Duengen(float fassungskapazitaet) {
		super(fassungskapazitaet);
	}

	public Float getFassungskapazitaet() {
		return menge.floatValue();
	}
}
