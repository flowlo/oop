package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import entity.Event;
import entity.EventType;
import entity.Member;

/**
 * Diese Klasse fuehrt alle Operationen aus.
 * Die Klasse Test (main) darf nur auf den Manager zugreifen!
 * 
 * @author Simon, Lorenz, Dominik
 */
public class Manager {

	private List<Member> members = new LinkedList<Member>();
	private TreeSet<Event> performances = new TreeSet<Event>();
	private TreeSet<Event> practices = new TreeSet<Event>();

	/**
	 * Listet alle Mitglieder zum angegebenen Zeitpunkt auf.
	 * 
	 * @param date
	 *            der relevante Zeitpunkt
	 * @return eine Liste der Mitglieder
	 */
	public List<Member> getMembers(Date date) {
		List<Member> result = new LinkedList<Member>();

		for (Member member : members) {
			if (member.isActive(date)) {
				result.add(member);
			}
		}

		return result;
	}

	/**
	 * Listet alle aktuellen Mitglieder auf.
	 * 
	 * @return eine Liste der Mitglieder
	 * @see #getMembers(Date)
	 */
	public List<Member> getCurrentMembers() {
		return getMembers(new Date());
	}

	/**
	 * Fügt ein Mitglied mit angegebenen Eigenschaften zur Band als aktiv hinzu.
	 * 
	 * @param name
	 *            der Name des neuen Mitglieds
	 * @param phoneNumber
	 *            die Telefonnummer des neuen Mitglieds
	 * @param instrument
	 *            das Instrument, dass das neue Mitglied in der Band spielt
	 */
	public void addMember(String name, String phoneNumber, String instrument) {
		members.add(new Member(name, phoneNumber, instrument));
	}

	/**
	 * Scheidet ein Mitglied aus der Band aus.
	 * 
	 * @param name
	 *            der Name des Mitglieds
	 */
	public void removeMember(String name) {
		for (Member member : members) {
			if (member.getName().equals(name)) {
				member.delete();
				return;
			}
		}
	}

	/**
	 * Hinzufuegen eines Auftritts
	 * 
	 * @param place
	 *            Der Ort
	 * @param date
	 *            Das Datum. Format: d.M.yyyy
	 * @param time
	 *            Die Start-Uhrzeit. Format: H:m
	 * @param duration
	 *            Die Dauer in Minuten
	 * @param money
	 *            Die Gage
	 * @throws ParseException
	 *             bei fehlerhafter Formatierung des Datums oder der Uhrzeit
	 */
	public void addPerformance(String place, String date, String time, int duration, int money) throws ParseException {
		performances.add(toEvent(place, date, time, duration, money, EventType.Performance));
	}

	/**
	 * Hinzufuegen einer Bandprobe
	 * 
	 * @param place
	 *            Der Ort
	 * @param date
	 *            Das Datum. Format: d.M.yyyy
	 * @param time
	 *            Die Start-Uhrzeit. Format: H:m
	 * @param duration
	 *            Die Dauer in Minuten
	 * @param money
	 *            Die Raummiete
	 * @throws ParseException
	 *             bei fehlerhafter Formatierung des Datums oder der Uhrzeit
	 */
	public void addPractice(String place, String date, String time, int duration, int money) throws ParseException {
		practices.add(toEvent(place, date, time, duration, money, EventType.Practice));
	}

	/**
	 * Erstellt einen Termin aus den gegeben Daten
	 * 
	 * @param place
	 *            Der Ort
	 * @param date
	 *            Das Datum. Format: d.M.yyyy
	 * @param time
	 *            Die Start-Uhrzeit. Format: H:m
	 * @param duration
	 *            Die Dauer in Minuten
	 * @param money
	 *            Die Raummiete
	 * @param type
	 *            Der Typ des Termins
	 * @return Der Termin
	 * @throws ParseException
	 */
	private Event toEvent(String place, String date, String time, int duration, int money, EventType type) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("d.M.yyyy-H:m");
		Date datetime = df.parse(date + "-" + time);
		return new Event(place, datetime, duration, money, type);
	}

	/**
	 * Listet alle Auftritte in einem gegebenen Zeitraum
	 * 
	 * @param start
	 *            Startzeitpunkt
	 * @param end
	 *            Endzeitpunkt
	 * @return Alle Auftritte in dem gegeben Zeitraum
	 */
	public Event[] listPerformances(Date start, Date end) {
		Event startDate = Event.getFromDate(start);
		Event endDate = Event.getFromDate(end);
		return (Event[]) performances.subSet(startDate, true, endDate, true).toArray();
	}

	/**
	 * Listet alle Bandproben in einem gegebenen Zeitraum
	 * 
	 * @param start
	 *            Startzeitpunkt
	 * @param end
	 *            Endzeitpunkt
	 * @return Alle Bandproben in dem gegeben Zeitraum
	 */
	public Event[] listPractices(Date start, Date end) {
		Event startDate = Event.getFromDate(start);
		Event endDate = Event.getFromDate(end);
		return (Event[]) practices.subSet(startDate, true, endDate, true).toArray();
	}

	/**
	 * Listet alle Termine in einem gegebenen Zeitraum
	 * 
	 * @param start
	 *            Startzeitpunkt
	 * @param end
	 *            Endzeitpunkt
	 * @return Alle Termine in dem gegeben Zeitraum
	 */
	public Event[] listEvents(Date start, Date end) {
		Event startDate = Event.getFromDate(start);
		Event endDate = Event.getFromDate(end);
		TreeSet<Event> set = new TreeSet<Event>();
		set.addAll(practices.subSet(startDate, true, endDate, true));
		set.addAll(performances.subSet(startDate, true, endDate, true));
		return (Event[]) set.toArray();
	}

	/**
	 * Berechnet die Gesamtgage aller Auftritte in einem gegeben Zeitraum
	 * 
	 * @param start
	 *            Startzeitpunkt
	 * @param end
	 *            Endzeitpunkt
	 * @return Die Gesamtgage des gegebenen Zeitraums
	 */
	public int getPerformanceSalary(Date start, Date end) {
		int salary = 0;
		Event startDate = Event.getFromDate(start);
		Event endDate = Event.getFromDate(end);
		for (Event e : practices.subSet(startDate, true, endDate, true)) {
			salary += e.getMoney();
		}
		return salary;
	}

	/**
	 * Berechnet die Gesamtkosten aller Bandproben in einem gegeben Zeitraum, die durch die Raummiete entstehen
	 * 
	 * @param start
	 *            Startzeitpunkt
	 * @param end
	 *            Endzeitpunkt
	 * @return Die Gesamtkosten des gegebenen Zeitraums
	 */
	public int getPracticeCosts(Date start, Date end) {
		int costs = 0;
		Event startDate = Event.getFromDate(start);
		Event endDate = Event.getFromDate(end);
		for (Event e : practices.subSet(startDate, true, endDate, true)) {
			costs += e.getMoney();
		}
		return costs;
	}

	/**
	 * Berechnet den Ertrag (Gagen - Kosten) aller Termine in einem gegeben Zeitraum
	 * 
	 * @param start
	 *            Startzeitpunkt
	 * @param end
	 *            Endzeitpunkt
	 * @return Der Ertrag des gegebenen Zeitraums
	 */
	public int getEarnings(Date start, Date end) {
		return getPerformanceSalary(start, end) - getPracticeCosts(start, end);
	}
}
