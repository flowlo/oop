import java.util.HashMap;
import java.util.Map;

/**
 * Zusicherungern:
 * * Der Name des Bauernhofs ist eindeutig und unveraenderlich
 */
@Author(Authors.Dominik)
public class Bauernhof {
	private final String name;
	private Map<Integer, Traktor> traktoren = new HashMap<Integer, Traktor>();

	public Bauernhof(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addTraktor(Traktor traktor) {
		traktoren.put(traktor.getNummer(), traktor);
	}

	public void removeTraktor(Traktor traktor) {
		traktoren.remove(traktor.getNummer());
	}

	public void erhoeheDieselVerbrauch(int nummer, Integer diesel) {
		Traktor traktor = traktoren.get(nummer);
		if (traktor != null && traktor instanceof DieselTraktor) {
			((DieselTraktor) traktor).erhoeheVerbrauch(diesel);
		}
	}

	public void erhoeheBiogasVerbrauch(int nummer, Float biogas) {
		Traktor traktor = traktoren.get(nummer);
		if (traktor != null && traktor instanceof BiogasTraktor) {
			((BiogasTraktor) traktor).erhoeheVerbrauch(biogas);
		}
	}

	public void setEinsatzzweck(int nummer, Einsatzzweck einsatzzweck) {
		Traktor traktor = traktoren.get(nummer);
		if (traktor != null) {
			traktor.setEinsazuzweck(einsatzzweck);
		}
	}

	public float getDurchschnittBetriebsstunden(EinsatzzweckGruppierung gruppierung) {
		boolean saeen = gruppierung.equals(EinsatzzweckGruppierung.Gesamt) || gruppierung.equals(EinsatzzweckGruppierung.Saeen);
		boolean duengen = gruppierung.equals(EinsatzzweckGruppierung.Gesamt) || gruppierung.equals(EinsatzzweckGruppierung.Duengen);
		int summe = 0;
		int anzahl = 0;

		for (Traktor traktor : traktoren.values()) {
			if ((traktor.tutDuengen() && duengen) || (traktor.tutSaeen() && saeen)) {
				anzahl += 1;
				summe += traktor.getBetriebsStunden();
			}
		}

		return ((float) summe) / anzahl;
	}

	public float getDurchschnittBetriebsstunden(TraktorGruppierung gruppierung) {
		boolean diesel = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Diesel);
		boolean biogas = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Biogas);
		int summe = 0;
		int anzahl = 0;

		for (Traktor traktor : traktoren.values()) {
			if ((traktor instanceof DieselTraktor && diesel) || (traktor instanceof BiogasTraktor && biogas)) {
				anzahl += 1;
				summe += traktor.getBetriebsStunden();
			}
		}

		return ((float) summe) / anzahl;
	}

	public float getDurchschnittDieselverbrauch(EinsatzzweckGruppierung gruppierung) {
		boolean saeen = gruppierung.equals(EinsatzzweckGruppierung.Gesamt) || gruppierung.equals(EinsatzzweckGruppierung.Saeen);
		boolean duengen = gruppierung.equals(EinsatzzweckGruppierung.Gesamt) || gruppierung.equals(EinsatzzweckGruppierung.Duengen);
		int summe = 0;
		int anzahl = 0;

		for (Traktor traktor : traktoren.values()) {
			if (traktor instanceof DieselTraktor && ((traktor.tutDuengen() && duengen) || (traktor.tutSaeen() && saeen))) {
				anzahl += 1;
				summe += ((DieselTraktor) traktor).getBisherigerVerbrauch();
			}
		}

		return ((float) summe) / anzahl;
	}

	public float getDurchschnittBiogasverbrauch(EinsatzzweckGruppierung gruppierung) {
		boolean saeen = gruppierung.equals(EinsatzzweckGruppierung.Gesamt) || gruppierung.equals(EinsatzzweckGruppierung.Saeen);
		boolean duengen = gruppierung.equals(EinsatzzweckGruppierung.Gesamt) || gruppierung.equals(EinsatzzweckGruppierung.Duengen);
		float summe = 0;
		int anzahl = 0;

		for (Traktor traktor : traktoren.values()) {
			if (traktor instanceof BiogasTraktor && ((traktor.tutDuengen() && duengen) || (traktor.tutSaeen() && saeen))) {
				anzahl += 1;
				summe += ((BiogasTraktor) traktor).getBisherigerVerbrauch();
			}
		}

		return summe / anzahl;
	}

	public float getMinimumSaescharen(TraktorGruppierung gruppierung) {
		boolean diesel = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Diesel);
		boolean biogas = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Biogas);
		int minimum = 0;

		for (Traktor traktor : traktoren.values()) {
			if ((traktor instanceof DieselTraktor && diesel) || (traktor instanceof BiogasTraktor && biogas)) {
				minimum = Math.min(minimum, traktor.getAnzahlSaeschare());
			}
		}

		return minimum;
	}

	public float getMaximumSaescharen(TraktorGruppierung gruppierung) {
		boolean diesel = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Diesel);
		boolean biogas = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Biogas);
		int maximum = 0;

		for (Traktor traktor : traktoren.values()) {
			if ((traktor instanceof DieselTraktor && diesel) || (traktor instanceof BiogasTraktor && biogas)) {
				maximum = Math.max(maximum, traktor.getAnzahlSaeschare());
			}
		}

		return maximum;
	}

	public float getDurchschnittFassungskapazitaet(TraktorGruppierung gruppierung) {
		boolean diesel = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Diesel);
		boolean biogas = gruppierung.equals(TraktorGruppierung.Gesamt) || gruppierung.equals(TraktorGruppierung.Biogas);
		float summe = 0;
		int anzahl = 0;

		for (Traktor traktor : traktoren.values()) {
			if ((traktor instanceof DieselTraktor && diesel) || (traktor instanceof BiogasTraktor && biogas)) {
				anzahl += 1;
				summe += traktor.getFassungskapazitaet();
			}
		}

		return summe / anzahl;
	}
}
