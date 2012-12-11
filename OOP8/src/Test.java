import java.lang.reflect.Method;

@Authors("Dominik, Simon")
public class Test {

	private static boolean failed = false;

	@Authors("Dominik")
	public static void main(String[] args) {
		mainTest();
		traktorTest();
		autorenTest();
	}

	@Authors("Simon")
	public static void mainTest() {
		System.out.println("Starte Test fuer mehrere Hoefe und Traktoren");
		System.out
				.println("Alle Hoefe durch Namen, alle Traktoren durch Nummern angesprochen.");
		// ---------------------------------------------------------------------------hoefe
		// einfuegen
		HofListe hoefe = new HofListe();
		hoefe.addBauernhof(new Bauernhof("Familie Gruber"));
		hoefe.addBauernhof(new Bauernhof("Familie Hofer"));
		hoefe.addBauernhof(new Bauernhof("Familie Mayer"));
		System.out.println("3 Hoefe angelegt: ");
		System.out.println(hoefe.getAlleNamen());

		// ---------------------------------------------------------------------------traktoren
		// einfuegen/loeschen
		DieselTraktor diesel1 = new DieselTraktor(new Duengen(3.5));
		System.out.println("Neuen Traktor fuer Familie Gruber...");
		hoefe.addTraktor("Familie Gruber", diesel1);
		System.out.print("Versuche Traktor fuer Familie Hofer zu loeschen ");
		if (!hoefe.removeTraktor("Familie Hofer", 1))
			System.out.println("PASSED");
		else
			System.out.println("FAILED");

		System.out.print("Versuche Traktor fuer Familie Gruber zu loeschen ");
		if (hoefe.removeTraktor("Familie Gruber", 1))
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out
				.print("Versuche Traktor fuer Familie Gruber noch einmal zu loeschen ");
		if (!hoefe.removeTraktor("Familie Gruber", 1))
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		// ---------------------------------------------------------------------------traktoren
		// Werte aendern
		System.out
				.print("Fuege Traktor wieder ein und erhoehe Betriebsstunden.");
		hoefe.addTraktor("Familie Gruber", diesel1);
		hoefe.erhoeheBetriebsStunden(1, 3);
		if (hoefe.getBetriebsStunden(1) == 3) {
			System.out.println("PASSED");
		} else
			System.out.println("FAILED");
		System.out.println("Der Traktor ist ein Dieseltraktor... ");
		System.out
				.print("Versuche Biogasverbrauch zu erhoehen (ACHTUNG bei Auswertung: division durch 0 -> Double.NaN)");
		hoefe.erhoeheBiogasVerbrauch(1, 22.2f);
		if (Double.isNaN(hoefe.getDurchschnittBiogasverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.GESAMT)))
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out.print("Erhoehe Dieselverbrauch ");
		hoefe.erhoeheDieselVerbrauch(1, 23);
		if (hoefe.getDurchschnittDieselverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.GESAMT) == 23)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");

		System.out.print("Fuege BiogasTraktor ein und teste ");
		Traktor biogas1 = new BiogasTraktor(new Saeen(2));
		hoefe.addTraktor("Familie Gruber", biogas1);
		hoefe.erhoeheBetriebsStunden(2, 20);
		hoefe.erhoeheBiogasVerbrauch(2, 24.12f);
		if (hoefe.getDurchschnittBiogasverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.GESAMT) == 24.12f)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		// ---------------------------------------------------------------------------weitere
		// Statistik tests
		hoefe.addTraktor("Familie Gruber", new DieselTraktor(new Saeen(12)));
		hoefe.addTraktor("Familie Gruber", new BiogasTraktor(new Saeen(7)));
		hoefe.erhoeheDieselVerbrauch(3, 7);
		hoefe.erhoeheBetriebsStunden(3, 8);
		hoefe.erhoeheBetriebsStunden(2, 5);
		hoefe.erhoeheBiogasVerbrauch(2, 1f);
		System.out.print("Erhalte max Saescharen von Familie Gruber ");
		if (hoefe.getMaximumSaescharen("Familie Gruber",
				TraktorGruppierung.GESAMT) == 12)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out.print("Erhalte max Saescharen der BiogasTraktoren ");
		if (hoefe.getMaximumSaescharen("Familie Gruber",
				TraktorGruppierung.BIOGAS) == 7)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out.println(hoefe.getMaximumSaescharen("Familie Gruber",
				TraktorGruppierung.GESAMT));
		System.out
				.print("Erhalte durchschnittliche Betriebsstunden von Famile Gruber (Gesamt) ");
		if (hoefe.getDurchschnittBetriebsstunden("Familie Gruber",
				EinsatzzweckGruppierung.GESAMT) == 9)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out
				.print("Erhalte durchschnittliche Betribsstunden von Fam Gruber (SAeEN) ");
		if (hoefe.getDurchschnittBetriebsstunden("Familie Gruber",
				EinsatzzweckGruppierung.SAEEN) == 11)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out
				.print("Erhalte durchschnittliche Betribsstunden von Fam Gruber (DUeNGEN) ");
		if (hoefe.getDurchschnittBetriebsstunden("Familie Gruber",
				EinsatzzweckGruppierung.DUENGEN) == 3)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");

		System.out.print("Teste durchschnittlicher Dieselverbrauch (GESAMT)");
		if (hoefe.getDurchschnittDieselverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.GESAMT) == 15)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out.print("Teste durchschnittlichen Dieselverbrauch (SAeEN) ");
		if (hoefe.getDurchschnittDieselverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.SAEEN) == 7)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out.print("Teste durchschnittlichen Dieselverbrauch (DuENGEN) ");
		if (hoefe.getDurchschnittDieselverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.DUENGEN) == 23)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");

		System.out.print("Teste durchschnittlichen Biogasverbrauch (GESAMT) ");
		if (12.56 < hoefe.getDurchschnittBiogasverbrauch("Familie Gruber",
				EinsatzzweckGruppierung.GESAMT)
				&& hoefe.getDurchschnittBiogasverbrauch("Familie Gruber", // rundung
						EinsatzzweckGruppierung.GESAMT) < 12.57)
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		System.out.println("Tests fuer Hoefe und Traktoren ENDE");
	}

	@Authors("Dominik")
	public static void traktorTest() {
		failed = false;
		System.out.println("Starte Traktoren-Test");
		System.out.println("  Erzeuge Dieseltraktor zum DUENGEN");

		DieselTraktor diesel = new DieselTraktor(new Duengen(3.5));
		diesel.erhoeheBetriebsstunden(4);
		diesel.erhoeheVerbrauch(3);
		diesel.erhoeheBetriebsstunden(6);
		diesel.erhoeheVerbrauch(2);

		assertThat("Betriebsstunden", 10, diesel.getBetriebsstunden());
		assertThat("Verbrauch", 5, diesel.getBisherigerVerbrauch());
		assertThat("Fassungskapazitaet", 3.5, diesel.getFassungskapazitaet());
		assertThat("Saeschare", 0, diesel.getAnzahlSaeschare());

		System.out.println("  Aendere Einsatzzweck auf SAEEN");
		diesel.setEinsatzzweck(new Saeen(8));
		assertThat("Fassungskapazitaet", 0.0, diesel.getFassungskapazitaet());
		assertThat("Saeschare", 8, diesel.getAnzahlSaeschare());

		System.out.println("  Erzeuge Dieseltraktor zum SAEEN");
		BiogasTraktor biogas = new BiogasTraktor(new Saeen(3));
		biogas.erhoeheBetriebsstunden(12);
		biogas.erhoeheVerbrauch(18);
		biogas.erhoeheBetriebsstunden(8);
		biogas.erhoeheVerbrauch(22);

		assertThat("Betriebsstunden", 20, biogas.getBetriebsstunden());
		assertThat("Verbrauch", 40.0, biogas.getBisherigerVerbrauch());
		assertThat("Fassungskapazitaet", 0.0, biogas.getFassungskapazitaet());
		assertThat("Saeschare", 3, biogas.getAnzahlSaeschare());

		System.out.println("  Aendere Einsatzzweck auf DUENGEN");
		biogas.setEinsatzzweck(new Duengen(4.23));
		assertThat("Fassungskapazitaet", 4.23, biogas.getFassungskapazitaet());
		assertThat("Saeschare", 0, biogas.getAnzahlSaeschare());

		if (failed) {
			System.out.println("Traktorentest FEHLGESCHLAGEN");
		} else {
			System.out.println("Traktorentest erfolgreich");
		}
	}

	@Authors("Dominik")
	public static void autorenTest() {
		System.out.println("\nStarte Autorentest");
		failed = false;

		printClass(Authors.class);
		printClass(Bauernhof.class);
		printClass(Bauernhof.TraktorenListe.class);
		printClass(Bauernhof.TraktorenListe.TraktorEintrag.class);
		printClass(BiogasTraktor.class);
		printClass(DieselTraktor.class);
		printClass(Duengen.class);
		printClass(Einsatzzweck.class);
		printClass(EinsatzzweckGruppierung.class);
		printClass(Saeen.class);
		printClass(Test.class);
		printClass(Traktor.class);
		printClass(TraktorGruppierung.class);
		printClass(HofListe.class);

		if (failed) {
			System.out.println("Autorentest FEHLGESCHLAGEN");
		} else {
			System.out.println("Autorentest erfolgreich");
		}
	}

	@Authors("Dominik")
	private static void printClass(Class<?> clazz) {
		System.out.println("  " + String.format("%-35s", clazz.getSimpleName())
				+ "Autoren: " + getAuthors(clazz));
		for (Method method : clazz.getMethods()) {
			System.out.println("    "
					+ String.format("%-35s", method.getName()) + "Autoren: "
					+ getAuthors(method));
		}
	}

	@Authors("Dominik")
	private static String getAuthors(Class<?> clazz) {
		if (clazz.isAnnotationPresent(Authors.class)) {
			return clazz.getAnnotation(Authors.class).value();
		} else {
			return "KEINE AUTOREN";
		}
	}

	@Authors("Dominik")
	private static String getAuthors(Method method) {
		if (method.isAnnotationPresent(Authors.class)) {
			return method.getAnnotation(Authors.class).value();
		} else {
			return "KEINE AUTOREN";
		}
	}

	@Authors("Dominik")
	private static void assertThat(String test, Object should, Object is) {
		if (should.equals(is)) {
			System.out.println("    PASSED: " + test + " - " + is);
		} else {
			System.out.println("    FAILED: " + test + " - Should be " + should
					+ ", but is " + is);
			failed = true;
		}
	}
}
