/**
 * Zusicherungen:
 * * Die Nummer des Traktors ist eindeutig und unveraenderlich
 * * Traktoren haben entweder Diesel- oder Biogas-Motoren
 * * Ein Traktor kann entweder nur zum Saeen oder nur zum Duengen verwendet werden
 */
@Author(Authors.Dominik)
public abstract class Traktor {
	private final int nummer;
	private int betriebsstunden;
	protected Number bisherigerVerbrauch;
	private Einsatzzweck einsatzzweck;

	public Traktor(int nummer, Einsatzzweck einsatzzweck) {
		this.nummer = nummer;
		this.einsatzzweck = einsatzzweck;
		betriebsstunden = 0;
		bisherigerVerbrauch = 0;
	}

	public int getNummer() {
		return nummer;
	}

	public void erhoeheBetriebsstunden(int stunden) {
		this.betriebsstunden += stunden;
	}

	public int getBetriebsstunden() {
		return betriebsstunden;
	}

	public void setEinsatzzweck(Einsatzzweck einsatzzweck) {
		this.einsatzzweck = einsatzzweck;
	}

	public int getAnzahlSaeschare() {
		if (einsatzzweck != null && einsatzzweck instanceof Saeen) {
			return ((Saeen) einsatzzweck).getSaeSchare();
		}
		else {
			return 0;
		}
	}

	public double getFassungskapazitaet() {
		if (einsatzzweck != null && einsatzzweck instanceof Duengen) {
			return ((Duengen) einsatzzweck).getFassungskapazitaet();
		}
		else {
			return 0f;
		}
	}

	public boolean tutSaeen() {
		return einsatzzweck != null && einsatzzweck instanceof Saeen;
	}

	public boolean tutDuengen() {
		return einsatzzweck != null && einsatzzweck instanceof Duengen;
	}
}
