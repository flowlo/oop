import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import service.BandManager;
import service.Manager;
import service.ServiceException;
import entity.Event;
import entity.Location;
import entity.Member;
import entity.Song;

/**
 * @author Simon
 * @author Lorenz
 * @author Dominik
 */
/*
 * Anmerkungen:
 * 
 * Unser Programm ist sehr unsauber programmiert, da wir es aus Zeitgruenden am Tag vor der Abgabe entwickelt haben.
 * Es liessen sich viele Punkte verbessern: Z.B. Exception-Handling, DTO-Pattern, etc.
 * Weiters sind in vielen Klassen (vor allem im entity-package) weder gut noch schlecht aus Sicht von Klassenzusammenhalt
 * und Objektkopplung. Sie liessen sich durch diverse design-Patterns weit verbessern.
 * Ergibt es Sinn, das Programm noch neu zu struturieren oder wird es nicht mehr weiterentwickelt? 
 */
public class Test {

	private static Manager manager;
	private static BandManager bandmanager;

	public static void main(String[] args) {

		manager = new Manager();
		Date start = new Date();

		boolean result = true;
		System.out.println("Starte Tests (" + start + ")");

		System.out.print("Als Administrator anmelden...");
		manager.login("admin", "password");

		System.out.println(" angemeldet als: " + manager.getCurrentUser());
		System.out.println("Erzeuge neue Band 'LOL'");
		System.out.println("Erzeuge neue Band 'COOL'");
		System.out.println("Erzeuge neue Band 'band of skulls'");
		try {
			bandmanager = manager.createBand("LOL");
			manager.createBand("COOL");
			manager.createBand("band of skulls");
		} catch (ServiceException e1) {
			result = false;
			e1.printStackTrace();
		}
		if (bandmanager == null)
		{
			System.out.println("TESTS FAILED (Band wurde nicht angelegt)");
			return;
		}
		System.out.println("Liste alle Bands auf: ");
		Set<String> bands = manager.getAllBands();
		for (String it : bands)
		{
			System.out.println(it);
		}
		System.out.println("Aktive Band: " + bandmanager.getBandName());

		try {
			if (!testMitglieder()) {
				result = false;
			}
		} catch (InterruptedException e) {
			System.out.println("INTERRUPTED");
			return;
		}
		try {
			if (!testSongs()) {
				result = false;
			}
		} catch (InterruptedException e) {
			System.out.println("INTERRUPTED");
			return;
		}

		if (!(testProben() && testAuftritte() && testVerdienst() && testLocations())) {
			result = false;
		}

		if (!testLoginAsUser()) {
			result = false;
		}

		if (result) {
			System.out.println("SUCCESS - ALL TESTS PASSED");
		}
		else {
			System.out.println("ERROR - TEST(S) FAILED");
		}
	}

	public static boolean testLoginAsUser()
	{
		boolean result = true;
		System.out.println("-----------------------------------------------");
		System.out.println("TESTE LOGIN EINES USERS");
		System.out.println("Admin abmelden");
		bandmanager = null;
		manager.logout();
		System.out.println("Anmelden als User 'Simon' mit Passwort 'falsches Passwort'");
		if (!manager.login("Simon", "falsches Passwort")) {
			System.out.println("SUCCESS - login war nicht erfolgreich");
		} else
		{
			System.out.println("FAILED - Login war bei falschem Passwort erfolgreich");
			result = false;
		}
		System.out.println("Versuche Bands anzuzeigen: ");
		if (manager.getAllBands() == null) {
			System.out.println("SUCCESS - Keine Bands angezeigt");
		} else
		{
			System.out.println("FAILED - Bands werden angezeigt");
			return false;
		}
		System.out.println("Anmelden als User 'Simon' mit korrektem Passwort 'geheim'");
		if (manager.login("Simon", "geheim"))
		{
			System.out.println("SUCCESS - Login erfolgreich");
		}
		else
		{
			System.out.println("FAILED");
			return false;
		}
		System.out.println("Liste alle Bands auf: ");
		Set<String> bands = manager.getAllBands();
		for (String it : bands)
		{
			System.out.println(it);
		}
		System.out.println("Versuche Zugriff auf Band 'COOL'");
		try {
			bandmanager = manager.getBand("COOL");

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		if (bandmanager != null) {
			System.out.println("FAILED - Zugriff erhalten");
			result = false;
		}
		else
		{
			System.out.println("SUCCESS - Zugriff verweigert");
		}
		System.out.println("Versuche auf eigene Band zuzugreifen: ");
		try {
			bandmanager = manager.getBand("LOL");
		} catch (ServiceException e) {
			System.out.println(e);
		}
		if (bandmanager == null)
		{
			System.out.println("FAILED - Kein Zugriff");
			result = false;
		} else {
			System.out.println("SUCCESS - Zugriff erhalten");
		}
		System.out.println("Versuche Mitglied anzulegen: ");
		try {
			bandmanager.addMember("", "", "", "", "", "");
			System.out.println("FAILED- Trotz falschen Rechten moeglich");
			result = false;
		} catch (ServiceException e) {
			System.out.print("SUCCESS -");
			System.out.println(e.getMessage());
		}
		System.out.println("USER TEST ENDE");
		System.out.println("-----------------------------------------------");

		return result;
	}

	public static boolean testVerdienst()
	{
		boolean result = true;
		float money = bandmanager.getEarnings(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime());
		if (money == 750 - 15)
		{
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println(" Verdienst (Gagen - Kosten) - soll=" + (750 - 15) + " ist=" + money);
		System.out.println("\n\n");
		return result;
	}

	public static boolean testAuftritte()
	{
		boolean result = true;

		System.out.println("-----------------------------------------------");
		System.out.println("AUFTRITTE TESTS");
		try {
			bandmanager.addPerformance("Vienna Unplugged", "Foogasse 41", "24.12.2012", "20:00", 60, 400);
			bandmanager.addPerformance("Escape", "Barweg 13/37", "02.05.2012", "21:15", 90, 350);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Es wurden 2 Auftritte gespeichert: ");
		List<Event> performances = bandmanager.listPerformances(new GregorianCalendar(2011, 1, 1).getTime(),
				new GregorianCalendar(2013, 1, 1).getTime());
		for (Event i : performances)
		{
			System.out.println(" " + i);
		}

		if (bandmanager.getPerformanceSalary(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime()) == 750)
		{
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Gagen aller Auftritte - soll=750 ist="
				+ bandmanager.getPerformanceSalary(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime()));

		System.out.println("AUFTRITTE TESTS ENDE");
		System.out.println("-----------------------------------------------");

		return result;

	}

	public static boolean testProben()
	{
		boolean result = true;

		List<Member> members = bandmanager.listMembers();
		members.get(0).getMessages(); // Clear messages
		if (members.get(0).getMessages().size() == 0) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Mitglieder-Benachrichtigungen leeren");

		System.out.println("-----------------------------------------------");
		System.out.println("PROBEN TESTS");

		System.out.println("....... Proben einfuegen");
		try {
			bandmanager.addPractice("Garage von Jonny", "Johnnyplatz", "22.12.2012", "13:45", 90, 0);
			bandmanager.addPractice("Keller von Jimmy", "Jimmystrasse", "11.11.2011", "11:11", 120, 3);
			bandmanager.addPractice("Proberaum", "im 20.", "21.05.2012", "13:45", 90, 12);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			result = false;
		}

		System.out.println("Es wurden 3 Proben gespeichert: ");

		if (members.get(0).getMessages().size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Mitglieder benachrichtigen");

		List<Event> practices = bandmanager.listPractices(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime());
		for (Event i : practices)
		{
			System.out.println(" " + i);
		}
		System.out.println("Proben im Jahr 2012:");
		practices = bandmanager.listPractices(new GregorianCalendar(2012, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime());
		for (Event i : practices)
		{
			System.out.println(" " + i);
		}

		if (bandmanager.getPracticeCosts(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime()) == 15)
		{
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Kosten aller Proben - soll=15 ist="
				+ bandmanager.getPracticeCosts(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime()));

		Event practice = practices.get(0);
		Event comparison = new Event(practice);
		try {
			bandmanager.moveEvent(practice, "23.12.2012", "14:00");
			Date date = Event.createDate("23.12.2012", "14:00");
			if (date.equals(practice.getDateTime())) {
				System.out.print("PASSED - ");
			} else {
				System.out.print("FAILED - ");
				result = false;
			}
			System.out.println("Probe verschieben");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			result = false;
		} catch (ParseException e) {
			e.printStackTrace();
			result = false;
		}

		if (members.get(0).getMessages().size() > 0) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Mitglieder benachrichtigen");

		bandmanager.cancelEvent(practice);
		if (practice.isCanceled()) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Probe absagen");

		if (members.get(0).getMessages().size() > 0) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Mitglieder benachrichtigen");

		Event comparisonInHistory = new Event(practice.getHistoryItem(0));
		practice.revert(0);

		if (practice.equals(comparison) && practice.equals(comparisonInHistory)) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Event wiederherstellen");

		System.out.println("PROBEN TESTS ENDE");
		System.out.println("-----------------------------------------------");

		return result;
	}

	public static boolean testMitglieder() throws InterruptedException
	{
		Date zwischenzeit;
		boolean result = true;
		System.out.println("-----------------------------------------------");
		System.out.println("MITGLIEDER TESTS");
		System.out.println("....... Fuege neue Mitglieder hinzu...");

		try
		{
			bandmanager.addMember("Simon", "Simon", "Osim", "geheim", "0900 666 666", "Gitarre");
			bandmanager.addMember("John Wayne", "John", "Wayne", "asdf", "01/41414141", "Maultrommel");
			bandmanager.addMember("Hansy", "Hans", "Wurst", "bla", "123456789", "Triangel");
		} catch (ServiceException e)
		{
			System.out.println(e.getMessage());
		}
		if (bandmanager.listMembers().size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfragen aktiver Mitglieder - soll=3 ist=" + bandmanager.listMembers().size());

		System.out.println("....... Warte 1 Sekunde...");

		Thread.sleep(1000);

		System.out.println("....... Zwischenzeit speichern");
		zwischenzeit = new Date();
		System.out.println("....... Warte 1 Sekunde...");
		Thread.sleep(1000);
		System.out.println("....... Loesche Mitglied 'John Wayne'");

		try {
			bandmanager.removeMember("John Wayne");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (bandmanager.listMembers().size() == 2) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfragen aktiver Mitglieder - soll=2 ist=" + bandmanager.listMembers().size());

		if (bandmanager.listMembers(zwischenzeit).size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfrage der Mitglieder vor dem Loeschen - soll=3 ist=" + bandmanager.listMembers(zwischenzeit).size()
				+ " ... (Mitglieder zum Zeitpunkt: " + zwischenzeit + ").");

		System.out.println("\nAuflisten von aktiven Mitgliedern: ");
		List<Member> member = bandmanager.listMembers();
		for (Member it : member)
		{
			System.out.println(" " + it.toString());
		}
		System.out.println("\nMITGLIEDER TESTS ENDE\n-----------------------------------------------");
		return result;
	}

	public static boolean testSongs() throws InterruptedException {
		Date zwischenzeit;
		boolean result = true;
		System.out.println("-----------------------------------------------");
		System.out.println("SONGS TESTS");
		System.out.println("....... Fuege neue Songs hinzu...");

		bandmanager.addSong("Radetzkymarsch", 1337);
		bandmanager.addSong("Affekt", 42);
		bandmanager.addSong("Bolero", ~0xdeadbeef);

		if (bandmanager.listSongs().size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfragen aktueller Songs - soll=3 ist=" + bandmanager.listSongs().size());

		System.out.println("....... Warte 1 Sekunde...");

		Thread.sleep(1000);

		System.out.println("....... Zwischenzeit speichern");
		zwischenzeit = new Date();
		System.out.println("....... Warte 1 Sekunde...");
		Thread.sleep(1000);
		System.out.println("....... Loesche Song 'Affekt'");

		bandmanager.removeSong("Affekt");
		if (bandmanager.listSongs().size() == 2) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfragen aktueller Songs - soll=2 ist=" + bandmanager.listSongs().size());

		if (bandmanager.listSongs(zwischenzeit).size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfrage der Songs vor dem Loeschen - soll=3 ist=" + bandmanager.listSongs(zwischenzeit).size()
				+ " ... (Mitglieder zum Zeitpunkt: " + zwischenzeit + ").");

		System.out.println("\nAuflisten von aktuellen Songs: ");
		List<Song> songs = bandmanager.listSongs();
		for (Song it : songs)
		{
			System.out.println(" " + it.toString());
		}
		System.out.println("\nSONGS TESTS ENDE\n-----------------------------------------------");
		return result;
	}

	public static boolean testLocations() {
		boolean result = true;
		System.out.println("Teste Locations ...");
		bandmanager.addLocation(new Location("Wiener Musikverein", "Musikvereinsplatz 1, 1010 Wien", "Garderobe", "Sitzplaetze", "Catering"));
		bandmanager.addLocation(new Location("Staatsoper", "Opernring 2, 1010 Wien", "Garderobe", "Sitzplaetze", "Stehplaetze", "Catering"));
		bandmanager.addLocation(new Location("Badeschiff", "Donaukanal", "Garderobe", "Sitzplaetze", "Stehplaetze", "Restaurant"));
		bandmanager.addLocation(new Location("Bach", "Bachgasse, 1160 Wien", "Garderobe", "Sitzplaetze", "Stehplaetze", "Bar"));

		if (bandmanager.getLocationsProviding("Catering").size() != 2) {
			System.out.println("Test 1 (Catering) fehlgeschlagen!");
			result = false;
		} else {
			System.out.println("Test 1 (Catering) erfolgreich!");
		}
		List<Location> tmp;
		tmp = bandmanager.getLocationsProviding("Bar");
		if (tmp.size() != 1) {
			System.out.println("Test 2 (Bar) fehlgeschlagen!");
		}
		else {
			if (tmp.get(0).getName().equals("Bach")) {
				System.out.println("Test 2 (Bar) erfolgreich!");
			}
			else {
				System.out.println("Test 2 (Bar) fehlgeschlagen!");
				result = false;
			}
		}
		tmp = bandmanager.getLocationsProviding("Restaurant");
		if (tmp.size() != 1) {
			System.out.println("Test 2 (Restaurant) fehlgeschlagen!");
		}
		else {
			if (tmp.get(0).getName().equals("Badeschiff")) {
				System.out.println("Test 2 (Restaurant) erfolgreich!");
			}
			else {
				System.out.println("Test 2 (Restaurant) fehlgeschlagen!");
				result = false;
			}
		}

		return result;
	}
}
