package service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import service.Session.rights;
import entity.BandObject;
import entity.Event;
import entity.Event.EventType;
import entity.Location;
import entity.Member;
import entity.Song;

/**
 * Diese Klasse fuehrt alle Operationen aus.
 * Die Klasse Test (mit main) darf nur auf den Manager zugreifen!
 * 
 * @author Simon
 * @author Lorenz
 * @author Dominik
 */
public class BandManager {
	//----
	private Collection<Member> members = new LinkedList<Member>();
	private Collection<Song> songs = new LinkedList<Song>();
	private List<Location> locations = new LinkedList<Location>();
	private TreeSet<Event> performances = new TreeSet<Event>();
	private TreeSet<Event> practices = new TreeSet<Event>();

	/*public BandManager()
	{
		User user = new User("admin", "password");
		user.setRights(rights.admin);
		try {
			userDao.createUser(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	/**
	 * Erzeugt eine neue Menge, die alle Elemente der gegebenen menge enthaelt,
	 * die zum gegebenen Zeitpunkt als aktiv gekennzeichnet sind.
	 * 
	 * @param date
	 *            Stichdatum
	 * @param collection
	 *            Menge der zu betrachtenden Objekte
	 * @return Teilmenge
	 */
	private <T extends BandObject> Collection<T> listBandObjects(Date date, Collection<T> collection) {
		Collection<T> result = new LinkedList<T>();

		for (T item : collection) {
			if (item.isActive(date)) {
				result.add(item);
			}
		}

		return result;
	}

	/**
	 * Entfernt das {@link entitiy.BandObject} mit dem gegebenen namen aus der gegebenen {@link java.util.Collection}.
	 * 
	 * @param name
	 *            Name/Bezeichnung des BandObjects
	 * @param collection
	 *            Menge aus der das Element geloescht werden soll.
	 */
	private <T extends BandObject> void removeBandObject(String name, Collection<T> collection) {
		for (T item : collection) {
			if (item.getName().equals(name)) {
				item.deactivate();
				return;
			}
		}
	}

	/**
	 * Listet alle aktuellen Songs der Band auf.
	 * 
	 * @return eine Liste der aktuell im Repertoire befindlichen Songs
	 */
	public Collection<Song> listSongs() {
		return listSongs(new Date());
	}

	/**
	 * Listet alle Songs die zu einem bestimmten Zeitpunkt im Repertoire der Band waren/sind.
	 * 
	 * @param date
	 *            Zeitpunkt, zu dem das Repertoire betrachtet werden soll
	 * @return eine Liste aller Songs
	 */
	public Collection<Song> listSongs(Date date) {
		return listBandObjects(date, songs);
	}

	/**
	 * Fuegt einen Song mit aktuellem Datum dem Repertoire der Band hinzu
	 * 
	 * @param name
	 *            die Bezeichnung/der Titel des Songs
	 * @param duration
	 *            die Abspieldauer des Songs
	 */
	public void addSong(String name, int duration) {
		songs.add(new Song(name, duration));
	}

	/**
	 * Entfernt einen Song mit gegebenem Namen mit dem aktuellem Datum
	 * aus dem Repertoire, bzw. markiert ihn als veraltet
	 * 
	 * @param name
	 *            die Bezeichnung des zu entfernenden Songs
	 */
	public void removeSong(String name) {
		removeBandObject(name, songs);
	}

	/**
	 * Listet alle Mitglieder zum angegebenen Zeitpunkt auf.
	 * 
	 * @param date
	 *            der relevante Zeitpunkt
	 * @return eine Liste der Mitglieder
	 */
	public Collection<Member> listMembers(Date date) {
		//return listBandObjects(date, members);
		Collection<Member> result = new LinkedList<Member>();

		for (Member item : this.members) {
			if (item.isActive(date)) {
				result.add(item);
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
	public Collection<Member> listMembers() {
		return listMembers(new Date());
	}

	/**
	 * Fuegt ein Mitglied mit angegebenen Eigenschaften zur Band als aktiv hinzu.
	 * 
	 * @param name
	 *            der Name des neuen Mitglieds
	 * @param phoneNumber
	 *            die Telefonnummer des neuen Mitglieds
	 * @param instrument
	 *            das Instrument, dass das neue Mitglied in der Band spielt
	 * @throws ServiceException
	 * @see #getMembers(Date)
	 * @see #getCurrentMembers()
	 */
	public void addMember(String name, String firstName, String lastName, String pwd, String phoneNumber, String instrument) throws ServiceException {
		if (Session.getRights() != rights.admin) {
			throw new ServiceException("PERMISSION DENIED - required rights: admin");
		}
		members.add(new Member(name, firstName, lastName, pwd, phoneNumber, instrument));
	}

	/**
	 * Scheidet ein Mitglied aus der Band aus.
	 * 
	 * @param loginName
	 *            der Login-Name des Mitglieds
	 * @throws ServiceException
	 */
	public void removeMember(String loginName) throws ServiceException {
		//removeBandObject(name, members);
		if (Session.getRights() != rights.admin) {
			throw new ServiceException("PERMISSION DENIED - required rights: admin");
		}
		for (Member item : members) {
			if (item.getLoginName().equals(loginName)) {
				item.deactivate();
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
	 * @throws ServiceException
	 */
	public void addPerformance(String place, String address, String date, String time, int duration, float money) throws ServiceException {
		addPerformanceAtLocation(new Location(place, address), date, time, duration, money);
	}

	public void addPerformanceAtLocation(Location place, String date, String time, int duration, float money) throws ServiceException {
		if (!locations.contains(place)) {
			locations.add(place);
		}

		int cent = (int) (100.0f * money);
		try {
			performances.add(Event.toEvent(place, date, time, duration, cent, EventType.Performance));
		} catch (ParseException e) {
			throw new ServiceException("ERROR - Fehler beim Speichern eines Auftritts - ungueltiges Datum/Format!");
		}
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
	 * @throws ServiceException
	 */
	public void addPractice(String place, String address, String date, String time, int duration, float money) throws ServiceException {
		addPracticeAtLocation(new Location(place, address), date, time, duration, money);
	}

	public void addPracticeAtLocation(Location place, String date, String time, int duration, float money) throws ServiceException {
		int cent = (int) (100.0f * money);
		try {
			if (!practices.add(Event.toEvent(place, date, time, duration, cent, EventType.Practice))) {
				throw new ServiceException("Probe bereits gespeichert");
			}
		} catch (ParseException e) {
			throw new ServiceException("ERROR - Fehler beim Speichern der Bandprobe - ungueltiges Datum/Format!");
		}
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
	public List<Event> listPerformances(Date start, Date end) {
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Performance);
		return new ArrayList<Event>(events);
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
	public List<Event> listPractices(Date start, Date end) {
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Practice);
		return new ArrayList<Event>(events);
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
	public List<Event> listEvents(Date start, Date end) {
		TreeSet<Event> set = new TreeSet<Event>();
		set.addAll(getEventsInTime(start, end, EventType.Performance));
		set.addAll(getEventsInTime(start, end, EventType.Practice));
		return new ArrayList<Event>(set);
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
	public float getPerformanceSalary(Date start, Date end) {
		int salary = 0;
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Performance);
		for (Event e : events) {
			salary += e.getMoney();
		}
		return salary / 100.0f;
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
	public float getPracticeCosts(Date start, Date end) {
		int costs = 0;
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Practice);
		for (Event e : events) {
			costs += e.getMoney();
		}
		return costs / 100.0f;
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
	public float getEarnings(Date start, Date end) {
		return getPerformanceSalary(start, end) - getPracticeCosts(start, end);
	}

	/**
	 * Sucht alle Termine eines bestimmten Typs innerhalb eines Zeitraums
	 * 
	 * @param start
	 *            Der Startzeitpunkt
	 * @param end
	 *            Der Endzeitpunkt
	 * @param type
	 *            Der Termintyp
	 * @return Alle Termine des gegeben Typs in dem gegebenen Zeitraum
	 */
	private NavigableSet<Event> getEventsInTime(Date start, Date end, EventType type) {
		Event startDate = Event.fromDate(start);
		Event endDate = Event.fromDate(end);
		if (type.equals(EventType.Performance)) {
			return performances.subSet(startDate, true, endDate, true);
		} else if (type.equals(EventType.Practice)) {
			return practices.subSet(startDate, true, endDate, true);
		} else {
			return null;
		}
	}

	public List<Location> getLocationsProviding(String infrastructure) {
		List<Location> result = new LinkedList<Location>();

		for (Location item : locations) {
			if (item.providesInfrastructure(infrastructure)) {
				result.add(item);
			}
		}

		return result;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public Location getLocation(String name) {
		for (Location item : locations) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public boolean addLocation(Location location) {
		return this.locations.add(location);
	}

	public boolean removeLocation(Location location) {
		return this.locations.remove(location);
	}

	public boolean removeLocation(String name) {
		return removeLocation(getLocation(name));
	}

}
