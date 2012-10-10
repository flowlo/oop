package service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import entity.Member;

/**
 * Diese Klasse führt alle Operationen aus.
 * Die Klasse Test (main) darf nur auf den Manager zugreifen!
 * @author Simon, Lorenz
 */
public class Manager {

	private List<Member> members = new LinkedList<Member>();
	
	/**
	 * Listet alle Mitglieder zum angegebenen Zeitpunkt auf.
	 * @param date der relevante Zeitpunkt
	 * @return eine Liste der Mitglieder
	 */
	public List<Member> getMembers(Date date) {
		List<Member> result = new LinkedList<Member>();
		
		for (Member member : members)
			if (member.isActive(date))
				result.add(member);
		
		return result;
	}
	
	/**
	 * Listet alle aktuellen Mitglieder auf.
	 * @return eine Liste der Mitglieder
	 * @see #getMembers(Date)
	 */
	public List<Member> getCurrentMembers() {
		return getMembers(new Date());
	}
	
	/**
	 * Fügt ein Mitglied mit angegebenen Eigenschaften zur Band als aktiv hinzu.
	 * @param name der Name des neuen Mitglieds
	 * @param phoneNumber die Telefonnummer des neuen Mitglieds
	 * @param instrument das Instrument, dass das neue Mitglied in der Band spielt
	 */
	public void addMember(String name, String phoneNumber, String instrument) {
		members.add(new Member(name, phoneNumber, instrument));
	}
	
	/**
	 * Scheidet ein Mitglied aus der Band aus.
	 * @param name der Name des Mitglieds
	 */
	public void removeMember(String name) {
		for (Member member : members) {
			if (member.getName().equals(name)) {
				member.delete();
				return;
			}
		}
	}
}
