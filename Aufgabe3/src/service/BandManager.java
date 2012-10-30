package service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import service.Session.rights;
import dao.DaoException;
import dao.TestUserDao;
import entity.BandObject;
import entity.Event;
import entity.Event.EventType;
import entity.Location;
import entity.Member;
import entity.Song;

/**
 * @author Simon
 * @author Lorenz
 * @author Dominik
 */
public class BandManager {
	private List<Member> members = new LinkedList<Member>();
	private List<Song> songs = new LinkedList<Song>();
	private List<Location> locations = new LinkedList<Location>();
	private TreeSet<Event> performances = new TreeSet<Event>();
	private TreeSet<Event> practices = new TreeSet<Event>();
	private TestUserDao users = new TestUserDao();

	private String bandName;

	public BandManager(String bandName)
	{
		this.bandName = bandName;
	}

	private <T extends BandObject> List<T> listBandObjects(Date date, List<T> collection) {
		List<T> result = new LinkedList<T>();

		for (T item : collection) {
			if (item.isActive(date)) {
				result.add(item);
			}
		}

		return result;
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: BandObject ist nicht mehr vorhanden
	 * SCHLECHT: BandObject kann nur noch ein Song sein. Die Methode kann in removeSong implementiert werden. 
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	private <T extends BandObject> void removeBandObject(String name, List<T> collection) {
		for (T item : collection) {
			if (item.getName().equals(name)) {
				item.deactivate();
				return;
			}
		}
	}

	public List<Song> listSongs() {
		return listSongs(new Date());
	}

	public List<Song> listSongs(Date date) {
		return listBandObjects(date, songs);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Song ist angelegt
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public void addSong(String name, int duration) {
		songs.add(new Song(name, duration));
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Song ist nicht mehr vorhanden
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public void removeSong(String name) {
		removeBandObject(name, songs);
	}

	public List<Member> listMembers(Date date) {
		//return listBandObjects(date, members);
		List<Member> result = new LinkedList<Member>();

		for (Member item : this.members) {
			if (item.isActive(date)) {
				result.add(item);
			}
		}

		return result;
	}

	public List<Member> listMembers() {
		return listMembers(new Date());
	}

	/*
	 * Vorbedingung: Benutzer hat die notwendigen Rechte
	 * Nachbedingung: Mitglied ist angelegt
	 */
	public void addMember(String loginName, String firstName, String lastName, String pwd, String phoneNumber, String instrument)
			throws ServiceException {
		if (Session.getRights() != rights.admin) {
			throw new ServiceException("PERMISSION DENIED - required rights: admin");
		}
		try {
			if (users.getUser(loginName) != null) {
				throw new ServiceException("ERROR - LoginName already in use.");
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		Member member = new Member(loginName, firstName, lastName, pwd, phoneNumber, instrument);
		try {
			users.createUser(member);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		members.add(member);
	}

	/*
	 * Vorbedingung: Benutzer hat die notwendigen Rechte
	 * Nachbedingung: Miglied wurde geloescht
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
		try {
			users.deleteUser(loginName);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Performance wurde angelegt
	 * SCHLECHT: Unnoetig. Zwei Parameter werden zu einem gemacht und weitergeleitet
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public void addPerformance(String place, String address, String date, String time, int duration, float money) throws ServiceException {
		addPerformanceAtLocation(new Location(place, address), date, time, duration, money);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Performance ist angelegt
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public void addPerformanceAtLocation(Location place, String date, String time, int duration, float money) throws ServiceException {
		if (!locations.contains(place)) {
			locations.add(place);
		}

		int cent = (int) (100.0f * money);
		try {
			Event event = Event.toEvent(place, date, time, duration, cent, EventType.Performance);
			performances.add(event);
			for (Member member : listMembers()) {
				member.addMessage("Neuer Auftritt: " + event.toString());
			}
		} catch (ParseException e) {
			throw new ServiceException("ERROR - Fehler beim Speichern eines Auftritts - ungueltiges Datum/Format!");
		}
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Probe wurde angelegt
	 * SCHLECHT: Unnoetig. Zwei Parameter werden zu einem gemacht und weitergeleitet
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public void addPractice(String place, String address, String date, String time, int duration, float money) throws ServiceException {
		addPracticeAtLocation(new Location(place, address), date, time, duration, money);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Probe wurde angelegt
	 * FEHLER: Rechte werden nicht ueberprueft
	 * FEHLER: Location wird nicht gespeichert
	 */
	public void addPracticeAtLocation(Location place, String date, String time, int duration, float money) throws ServiceException {
		int cent = (int) (100.0f * money);
		try {
			Event event = Event.toEvent(place, date, time, duration, cent, EventType.Practice);
			if (!practices.add(event)) {
				throw new ServiceException("Probe bereits gespeichert");
			}
			for (Member member : listMembers()) {
				member.addMessage("Neue Probe: " + event.toString());
			}
		} catch (ParseException e) {
			throw new ServiceException("ERROR - Fehler beim Speichern der Bandprobe - ungueltiges Datum/Format!");
		}
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Event wurde abgesagt
	 * FEHLER: Rechte werden nicht ueberprueft
	 * FEHLER: Es wird nicht ueberprueft, ob Event in der Liste ist
	 */
	public void cancelEvent(Event event) {
		event.setCanceled(true);
		String type = "";
		if (event.getType().equals(EventType.Performance)) {
			type = "Auftritt";
		} else if (event.getType().equals(EventType.Practice)) {
			type = "Probe";
		}
		for (Member member : listMembers()) {
			member.addMessage(type + " abgesagt: " + event.toString());
		}
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Event wurde verschoben
	 * FEHLER: Rechte werden nicht ueberprueft
	 * FEHLER: Es wird nicht ueberprueft, ob Event in der Liste ist
	 */
	public void moveEvent(Event event, String date, String time) throws ServiceException {
		String type = "";
		if (event.getType().equals(EventType.Performance)) {
			type = "Auftritt";
		} else if (event.getType().equals(EventType.Practice)) {
			type = "Probe";
		}

		try {
			Date datetime = Event.createDate(date, time);
			event.edit(null, datetime, null, null, null, null, null, null);
			for (Member member : listMembers()) {
				member.addMessage(type + " verschoben: " + event.toString());
			}
		} catch (ParseException e) {
			throw new ServiceException("ERROR - Fehler beim Verschieben von " + type + " - ungueltiges Datum/Format!");
		}
	}

	public List<Event> listPerformances(Date start, Date end) {
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Performance);
		return new ArrayList<Event>(events);
	}

	public List<Event> listPractices(Date start, Date end) {
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Practice);
		return new ArrayList<Event>(events);
	}

	public List<Event> listEvents(Date start, Date end) {
		TreeSet<Event> set = new TreeSet<Event>();
		set.addAll(getEventsInTime(start, end, EventType.Performance));
		set.addAll(getEventsInTime(start, end, EventType.Practice));
		return new ArrayList<Event>(set);
	}

	// FEHLER: Rechte werden nicht ueberprueft
	public float getPerformanceSalary(Date start, Date end) {
		int salary = 0;
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Performance);
		for (Event e : events) {
			salary += e.getMoney();
		}
		return salary / 100.0f;
	}

	// FEHLER: Rechte werden nicht ueberprueft
	public float getPracticeCosts(Date start, Date end) {
		int costs = 0;
		NavigableSet<Event> events = getEventsInTime(start, end, EventType.Practice);
		for (Event e : events) {
			costs += e.getMoney();
		}
		return costs / 100.0f;
	}

	// FEHLER: Rechte werden nicht ueberprueft
	public float getEarnings(Date start, Date end) {
		return getPerformanceSalary(start, end) - getPracticeCosts(start, end);
	}

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

	/*
	 * Vorbedingung: 
	 * Nachbedingung: Location wurde hinzugefuegt
	 * FEHLER: Rechte werden nicht ueberprueft
	 * FEHLER: Es wird nicht ueberprueft, ob die Location schon existiert. Dadurch entstehen inkonsistenzen,
	 *         da Elemente mehrfach hinzugefuegt werden koennen. Funktion liefert immer true zurueck.
	 * SCHLECHT: Wird nie verwendet, sondern eigens implementiert
	 */
	public boolean addLocation(Location location) {
		return this.locations.add(location);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Location existiert nicht mehr
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public boolean removeLocation(Location location) {
		return this.locations.remove(location);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Location existiert nicht mehr
	 * FEHLER: Rechte werden nicht ueberprueft
	 */
	public boolean removeLocation(String name) {
		return removeLocation(getLocation(name));
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

}
