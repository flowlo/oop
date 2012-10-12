import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import service.Manager;
import entity.Event;
import entity.Member;

/**
 * Fuehrt saemtliche Tests aus. Darf nur auf den Manager zugreifen.
 * 
 * @author Simon
 */
public class Test {

	private static Manager manager;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		manager = new Manager();
		Date start = new Date(System.currentTimeMillis());

		boolean result = true;
		System.out.println("Starte Tests (" + start + ")");

		/*try {
			if (!testMitglieder()) {
				result = false;
			}
		} catch (InterruptedException e) {
			System.out.println("INTERRUPTED");
			return;
		}*/

		testProben();

	}

	public static boolean testProben()
	{
		boolean result = true;

		System.out.println("-----------------------------------------------");
		System.out.println("PROBEN TESTS");

		System.out.println("....... Proben einfügen");
		manager.addPractice("Garage von Jonny", "22.12.2012", "13:45", 90, 0);
		manager.addPractice("Keller von Jimmy", "11.11.2011", "11:11", 120, 3);
		manager.addPractice("Proberaum im 20.", "11.12.2012", "13:45", 90, 12);
		System.out.println("Es wurden 3 Proben gespeichert: ");

		List<Event> practices = manager.listPractices(new GregorianCalendar(2011, 1, 1).getTime(), new GregorianCalendar(2013, 1, 1).getTime());
		for (Event i : practices)
		{
			System.out.println(i);
		}

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

		manager.addMember("Simon", "0900 666 666", "Gitarre");
		manager.addMember("John Wayne", "01/41414141", "Maultrommel");
		manager.addMember("Hans Wurst", "123456789", "Triangel");

		if (manager.listCurrentMembers().size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfragen aktiver Mitglieder - soll=3 ist=" + manager.listCurrentMembers().size());

		//----------------------------------------------------------------------------------
		System.out.println("....... Warte 1 Sekunde...");

		Thread.sleep(1000);

		System.out.println("....... Zwischenzeit speichern");
		zwischenzeit = new Date(System.currentTimeMillis());
		System.out.println("....... Warte 1 Sekunde...");
		Thread.sleep(1000);
		//----------------------------------------------------------------------------------
		System.out.println("....... Loesche Mitglied 'John Wayne'");

		manager.removeMember("John Wayne");
		if (manager.listCurrentMembers().size() == 2) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfragen aktiver Mitglieder - soll=2 ist=" + manager.listCurrentMembers().size());

		if (manager.listMembers(zwischenzeit).size() == 3) {
			System.out.print("PASSED - ");
		} else {
			System.out.print("FAILED - ");
			result = false;
		}
		System.out.println("Abfrage der Mitglieder vor dem Loeschen - soll=3 ist=" + manager.listMembers(zwischenzeit).size()
				+ " ... (Mitglieder zum Zeitpunkt: " + zwischenzeit + ").");

		System.out.println("\n....Auflisten von aktiven Mitgliedern: ");
		List<Member> member = manager.listCurrentMembers();
		for (Member it : member)
		{
			System.out.println(it.toString());
		}
		System.out.println("\nMITGLIEDER TESTS ENDE\n-----------------------------------------------");
		return result;
	}

}
