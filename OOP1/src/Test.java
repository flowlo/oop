import java.util.Date;
import java.util.List;

import entity.Member;

import service.Manager;


/**
 * FÃ¼hrt sÃ¤mtliche Tests aus. Darf nur auf den Manager zugreifen.
 * @author Simon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager=new Manager();
		Date start=new Date(System.currentTimeMillis());
		Date zwischenzeit;
		System.out.println("Starte Tests ("+start+")");
		System.out.println("-----------------------------------------------");
		System.out.println("MITGLIEDER TESTS");
		System.out.println(".....Fuege neue Mitglieder hinzu...");
		
		manager.addMember("Simon", "0900 666 666", "Gitarre");
		manager.addMember("John Wayne", "01/41414141", "Maultrommel");
		manager.addMember("Hans Wurst", "123456789", "Triangel");
		
		if(manager.getCurrentMembers().size()==3) System.out.print("PASSED - ");
		else System.out.print("FAILED - ");
		System.out.println("Abfragen aktiver Mitglieder - soll=3 ist="+manager.getCurrentMembers().size());
		
		//----------------------------------------------------------------------------------
		System.out.println("....Warte 1 Sekunde...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("INTERRUPTED");
			return;
		}
		System.out.println("....Zwischenzeit speichern");
		zwischenzeit=new Date(System.currentTimeMillis());		
		System.out.println("....Warte 1 Sekunde...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("INTERRUPTED");
			return;
		}
		//----------------------------------------------------------------------------------
		System.out.println("....Lösche Mitglied 'John Wayne'");
		
		manager.removeMember("John Wayne");
		if(manager.getCurrentMembers().size()==2) System.out.print("PASSED - ");
		else System.out.print("FAILED - ");
		System.out.println("Abfragen aktiver Mitglieder - soll=2 ist="+manager.getCurrentMembers().size());
		
		if(manager.getMembers(zwischenzeit).size()==3)  System.out.print("PASSED - ");
		else System.out.print("FAILED - ");
		System.out.println("Abfrage der Mitglieder vor dem Löschen - soll=3 ist="+manager.getMembers(zwischenzeit).size()+" ... (Mitglieder zum Zeitpunkt: "+zwischenzeit+").");
		
		System.out.println("\n....Auflisten von aktiven Mitgliedern: ");
		List<Member> member=manager.getCurrentMembers();
		for(Member it:member)
		{
			System.out.println(it.toString());
		}
		System.out.println();
	}

}
