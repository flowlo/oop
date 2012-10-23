package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repraesentiert sowohl eine Probe, als auch einen Auftritt
 * 
 * @author Dominik
 */
public class Event extends Item implements Comparable<Event> {
	/**
	 * Ort der Veranstaltung (Probe/Auftritt).
	 */
	private Location location;

	/**
	 * Dauer dieses Events in Sekunden.
	 */
	private int duration;

	/**
	 * Typ dieses Events, um zwischen Probe und Auftritt zu unterscheiden.
	 */
	private EventType type;

	private List<Event> history = new ArrayList<Event>();

	private boolean blockSave = false;

	private boolean canceled = false;

	/**
	 * Neues Event erstellen
	 * 
	 * @param place
	 *            Ort der Veranstaltung
	 * @param date
	 *            Datum und Uhrzeit
	 * @param duration
	 *            Dauer in Minuten
	 * @param money
	 *            Kosten/Gage in Euro
	 * @param type
	 *            typ des Events
	 */
	public Event(Location location, Date dateTime, int duration, int money, EventType type) {
		this.location = location;
		this.dateTime = dateTime;
		this.duration = duration;
		this.money = money;
		this.type = type;
	}

	public Event(Event event) {
		this.location = event.getLocation();
		this.dateTime = event.getDateTime();
		this.duration = event.getDuration();
		this.comment = event.getComment();
		this.money = event.getMoney();
		this.type = event.getType();
		this.deleted = event.isDeleted();
		this.canceled = event.isCanceled();
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		save();
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		save();
		this.location = location;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		save();
		this.duration = duration;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		save();
		this.canceled = canceled;
	}

	@Override
	public void save() {
		if (!blockSave) {
			history.add(new Event(this));
		}
	}

	@Override
	public Event getHistoryItem(int version) {
		if (history.size() > version) {
			return history.get(version);
		} else {
			return null;
		}
	}

	@Override
	public List<Event> getHistory() {
		return history;
	}

	@Override
	public void revert(int version) {
		revert(getHistoryItem(version));
	}

	@Override
	public void revert(Item version) {
		if (version != null) {
			if (version instanceof Event) {
				Event eventVersion = (Event) version;
				edit(eventVersion);
			}
		}
	}

	public void edit(Event event) {
		edit(event.getLocation(), event.getDateTime(), event.getDuration(), event.getMoney(), event.getType(), event.getComment(), event.isDeleted(),
				event.isCanceled());
	}

	public void edit(Location location, Date dateTime, Integer duration, Integer money, EventType type, String comment, Boolean deleted,
			Boolean canceled) {
		blockSave = true;
		save();
		if (location != null) {
			setLocation(location);
		}
		if (dateTime != null) {
			setDateTime(dateTime);
		}
		if (duration != null) {
			setDuration(duration);
		}
		if (money != null) {
			setMoney(money);
		}
		if (comment != null) {
			setComment(comment);
		}
		if (type != null && type != EventType.Dummy) {
			setType(type);
		}
		if (deleted != null) {
			setDeleted(deleted);
		}
		if (canceled != null) {
			setCanceled(canceled);
		}
		blockSave = false;
	}

	@Override
	public int compareTo(Event o) {
		return dateTime.compareTo(o.getDateTime());
	}

	@Override
	public String toString() {
		String typeString = "Termin";
		String moneyString = "Geld";
		if (type.equals(EventType.Performance)) {
			typeString = "Auftritt";
			moneyString = "Gage";
		} else if (type.equals(EventType.Practice)) {
			typeString = "Probe";
			moneyString = "Miete";
		}

		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return typeString + " - Datum: " + df.format(dateTime) + " - Dauer: "
				+ duration + " Minuten - " + moneyString + ": " + money;
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
	public static Event toEvent(Location location, String dateTime, String time, int duration, int money, EventType type) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("d.M.yyyy-H:m");
		df.setLenient(false);
		Date datetime = df.parse(dateTime + "-" + time);
		return new Event(location, datetime, duration, money, type);
	}

	public static Event fromDate(Date date) {
		return new Event(new Location("", ""), date, 1, 0, EventType.Dummy);
	}

	public enum EventType {
		Performance,
		Practice,
		Dummy
	}
}
