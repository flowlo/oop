@Author(Authors.Dominik)
public class Test {

	private static boolean failed = false;

	public static void main(String[] args) {
		traktorTest();
	}

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

	private static void assertThat(String test, Object should, Object is) {
		if (should.equals(is)) {
			System.out.println("    PASSED: " + test + " - " + is);
		} else {
			System.out.println("    FAILED: " + test + " - Should be " + should + ", but is " + is);
			failed = true;
		}
	}

}
