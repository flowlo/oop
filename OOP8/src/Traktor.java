/**
 * Zusicherungen:
 * * Die Nummer des Traktors ist eindeutig und unveraenderlich
 * * Traktoren haben entweder Diesel- oder Biogas-Motoren
 * * Ein Traktor kann entweder nur zum Saeen oder nur zum Duengen verwendet werden
 */
@Author(Authors.Dominik)
public abstract class Traktor {
	private final int nummer;
	private int betriebsStunden;
	protected Number bisherigerVerbrauch;
	private Einsatzzweck einsatzzweck;

	public Traktor(int nummer, Einsatzzweck einsatzzweck) {
		this.nummer = nummer;
		this.einsatzzweck = einsatzzweck;
		betriebsStunden = 0;
		bisherigerVerbrauch = 0;
	}

	public int getNummer() {
		return nummer;
	}

	public int getBetriebsStunden() {
		return betriebsStunden;
	}

	public void setEinsazuzweck(Einsatzzweck einsatzzweck) {
		this.einsatzzweck = einsatzzweck;
	}

	public Integer getAnzahlSaeschare() {
		if (einsatzzweck != null && einsatzzweck instanceof Saeen) {
			return ((Saeen) einsatzzweck).getSaeSchare();
		}
		else {
			return 0;
		}
	}

	public Float getFassungskapazitaet() {
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
