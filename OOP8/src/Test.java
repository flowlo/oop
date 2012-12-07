import java.lang.reflect.Method;

@Authors(Author.Dominik)
public class Test {

	private static boolean failed = false;

	@Authors(Author.Dominik)
	public static void main(String[] args) {
		traktorTest();
		autorenTest();
	}

	@Authors(Author.Dominik)
	public static void traktorTest() {
		failed = false;

		System.out.println("Starte Traktoren-Test");
		System.out.println("  Erzeuge Dieseltraktor zum Duengen");

		DieselTraktor diesel = new DieselTraktor(1, new Duengen(3.5));
		diesel.erhoeheBetriebsstunden(4);
		diesel.erhoeheVerbrauch(3);
		diesel.erhoeheBetriebsstunden(6);
		diesel.erhoeheVerbrauch(2);

		assertThat("Betriebsstunden", 10, diesel.getBetriebsstunden());
		assertThat("Verbrauch", 5, diesel.getBisherigerVerbrauch());
		assertThat("Fassungskapazitaet", 3.5, diesel.getFassungskapazitaet());
		assertThat("Saeschare", 0, diesel.getAnzahlSaeschare());

		System.out.println("  Aendere Einsatzzweck auf Saeen");
		diesel.setEinsatzzweck(new Saeen(8));
		assertThat("Fassungskapazitaet", 0.0, diesel.getFassungskapazitaet());
		assertThat("Saeschare", 8, diesel.getAnzahlSaeschare());

		System.out.println("  Erzeuge Dieseltraktor zum Saeen");
		BiogasTraktor biogas = new BiogasTraktor(2, new Saeen(3));
		biogas.erhoeheBetriebsstunden(12);
		biogas.erhoeheVerbrauch(18);
		biogas.erhoeheBetriebsstunden(8);
		biogas.erhoeheVerbrauch(22);

		assertThat("Betriebsstunden", 20, biogas.getBetriebsstunden());
		assertThat("Verbrauch", 40.0, biogas.getBisherigerVerbrauch());
		assertThat("Fassungskapazitaet", 0.0, biogas.getFassungskapazitaet());
		assertThat("Saeschare", 3, biogas.getAnzahlSaeschare());

		System.out.println("  Aendere Einsatzzweck auf Duengen");
		biogas.setEinsatzzweck(new Duengen(4.23));
		assertThat("Fassungskapazitaet", 4.23, biogas.getFassungskapazitaet());
		assertThat("Saeschare", 0, biogas.getAnzahlSaeschare());

		if (failed) {
			System.out.println("Traktorentest FEHLGESCHLAGEN");
		} else {
			System.out.println("Traktorentest erfolgreich");
		}
	}

	@Authors(Author.Dominik)
	public static void autorenTest() {
		System.out.println("\nStarte Autorentest");
		failed = false;

		printClass(Author.class);
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

		if (failed) {
			System.out.println("Autorentest FEHLGESCHLAGEN");
		} else {
			System.out.println("Autorentest erfolgreich");
		}
	}

	@Authors(Author.Dominik)
	private static void printClass(Class<?> clazz) {
		System.out.println("  " + String.format("%-35s", clazz.getSimpleName()) + "Autoren: " + getAuthors(clazz));
		for (Method method : clazz.getMethods()) {
			System.out.println("    " + String.format("%-35s", method.getName()) + "Autoren: " + getAuthors(method));
		}
	}

	@Authors(Author.Dominik)
	private static String getAuthors(Class<?> clazz) {
		if (clazz.isAnnotationPresent(Authors.class)) {
			return getAuthors(clazz.getAnnotation(Authors.class));
		} else {
			return "KEINE AUTOREN";
		}
	}

	@Authors(Author.Dominik)
	private static String getAuthors(Method method) {
		if (method.isAnnotationPresent(Authors.class)) {
			return getAuthors(method.getAnnotation(Authors.class));
		} else {
			return "KEINE AUTOREN";
		}
	}

	@Authors(Author.Dominik)
	private static String getAuthors(Authors authors) {
		String autoren = "";
		for (Author author : authors.value()) {
			autoren += ", " + author.toString();
		}
		return autoren.substring(2);
	}

	@Authors(Author.Dominik)
	private static void assertThat(String test, Object should, Object is) {
		if (should.equals(is)) {
			System.out.println("    PASSED: " + test + " - " + is);
		} else {
			System.out.println("    FAILED: " + test + " - Should be " + should + ", but is " + is);
			failed = true;
		}
	}
}
