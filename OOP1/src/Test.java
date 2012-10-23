import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import service.BandManager;
import service.Manager;
import service.ServiceException;
import entity.Event;
import entity.Location;
import entity.Member;
import entity.Song;

/**
 * Fuehrt saemtliche Tests aus. Darf nur auf den bandmanager zugreifen.
 * 
 * @author Simon
 * @author Lorenz
 */
public class Test {

	private static Manager manager;
	private static BandManager bandmanager;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		manager = new Manager();
		Date start = new Date();

		boolean result = true;
		System.out.println("Starte Tests (" + start + ")");

		//-----------------------------------------------------------------
		manager.login("admin", "password");
		try {
			bandmanager = manager.createBand("LOL");
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//-----------------------------------------------------------------

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

		if (result) {
			System.out.println("SUCCESS - ALL TESTS PASSED");
		}
		else {
			System.out.println("ERROR - TEST(S) FAILED");
		}

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
		System.out.println("Es wurden 2 Auftritte gepseichert: ");
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

		System.out.println("-----------------------------------------------");
		System.out.println("PROBEN TESTS");

		System.out.println("....... Proben einfuegen");
		try {
			bandmanager.addPractice("Garage von Jonny", "Johnnyplatz", "22.12.2012", "13:45", 90, 0);
			bandmanager.addPractice("Keller von Jimmy", "Jimmystraße", "11.11.2011", "11:11", 120, 3);
			bandmanager.addPractice("Proberaum", "im 20.", "21.12.2012", "13:45", 90, 12);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Es wurden 3 Proben gespeichert: ");

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
		bandmanager.moveEvent(practice, new Date());

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
			bandmanager.addMember("John Wayne", "John", "Wayne", "geheim", "01/41414141", "Maultrommel");
			bandmanager.addMember("Hansy", "Hans", "Wurst", "geheim", "123456789", "Triangel");
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

		//----------------------------------------------------------------------------------
		System.out.println("....... Warte 1 Sekunde...");

		Thread.sleep(1000);

		System.out.println("....... Zwischenzeit speichern");
		zwischenzeit = new Date();
		System.out.println("....... Warte 1 Sekunde...");
		Thread.sleep(1000);
		//----------------------------------------------------------------------------------
		System.out.println("....... Loesche Mitglied 'John Wayne'");

		try {
			bandmanager.removeMember("John Wayne");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
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
		Collection<Member> member = bandmanager.listMembers();
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

		//----------------------------------------------------------------------------------
		System.out.println("....... Warte 1 Sekunde...");

		Thread.sleep(1000);

		System.out.println("....... Zwischenzeit speichern");
		zwischenzeit = new Date();
		System.out.println("....... Warte 1 Sekunde...");
		Thread.sleep(1000);
		//----------------------------------------------------------------------------------
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
		Collection<Song> songs = bandmanager.listSongs();
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
