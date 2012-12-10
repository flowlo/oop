/**
 * Zusicherungen: * Die Nummer des Traktors ist eindeutig und unveraenderlich *
 * Traktoren haben entweder DIESEL- oder BIOGAS-Motoren * Ein Traktor kann
 * entweder nur zum SAEEN oder nur zum DUENGEN verwendet werden
 */
@Authors("Dominik")
public abstract class Traktor {
	private static int IDCounter = 0;
	private final int nummer;
	private int betriebsstunden;
	protected Number bisherigerVerbrauch;
	private Einsatzzweck einsatzzweck;

	@Authors("Dominik")
	public Traktor(Einsatzzweck einsatzzweck) {
		IDCounter++;
		this.nummer = IDCounter;
		this.einsatzzweck = einsatzzweck;
		betriebsstunden = 0;
		bisherigerVerbrauch = 0;
	}

	@Authors("Dominik")
	public int getNummer() {
		return nummer;
	}

	@Authors("Dominik")
	public void erhoeheBetriebsstunden(int stunden) {
		this.betriebsstunden += stunden;
	}

	@Authors("Dominik")
	public int getBetriebsstunden() {
		return betriebsstunden;
	}

	@Authors("Dominik")
	public void setEinsatzzweck(Einsatzzweck einsatzzweck) {
		this.einsatzzweck = einsatzzweck;
	}

	@Authors("Dominik")
	public int getAnzahlSaeschare() {
		if (einsatzzweck != null && einsatzzweck instanceof Saeen) {
			return ((Saeen) einsatzzweck).getSaeSchare();
		} else {
			return 0;
		}
	}

	@Authors("Dominik")
	public double getFassungskapazitaet() {
		if (einsatzzweck != null && einsatzzweck instanceof Duengen) {
			return ((Duengen) einsatzzweck).getFassungskapazitaet();
		} else {
			return 0d;
		}
	}

	@Authors("Dominik")
	public boolean tutSaeen() {
		return einsatzzweck != null && einsatzzweck instanceof Saeen;
	}

	@Authors("Dominik")
	public boolean tutDuengen() {
		return einsatzzweck != null && einsatzzweck instanceof Duengen;
	}
}
