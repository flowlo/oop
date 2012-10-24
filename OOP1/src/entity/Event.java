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

	/**
	 * Event ist abgesagt
	 */
	private boolean canceled = false;

	/**
	 * Event ist bestätigt
	 */
	private boolean confirmed = false;

	/**
	 * Speichert die Änderungen in einer History
	 */
	private List<Event> history = new ArrayList<Event>();

	/**
	 * Blockiert das Sepichern, um nicht f�r jedes Feld ein neues History-Element anzulegen
	 */
	private boolean blockSave = false;

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

	/**
	 * Deep-Copy-Constructor
	 * 
	 * @param event
	 *            das Event, von dem eine tiefe Kopie erstellt werden soll
	 */
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

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
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
		save();
		blockSave = true;
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

		String dateInfo = "";
		if (dateTime.compareTo(new Date()) > 0) {
			dateInfo = " (ausstehend)";
		} else if (confirmed) {
			dateInfo = "(bestätigt)";
		}

		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return typeString + " - Datum: " + df.format(dateTime) + dateInfo + " - Dauer: "
				+ duration + " Minuten - " + moneyString + ": " + money;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Event) {
			Event test = (Event) object;
			return test.getComment().equals(comment) &&
					test.getDateTime().equals(dateTime) &&
					test.getDuration() == duration &&
					test.getLocation().equals(location) &&
					test.getMoney() == money &&
					test.getType().equals(type);
		} else {
			return false;
		}
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
	public static Event toEvent(Location location, String date, String time, int duration, int money, EventType type) throws ParseException {
		return new Event(location, createDate(date, time), duration, money, type);
	}

	/**
	 * Erzeugt ein Date zu einem gegeben Datum und einer gegebenen Uhrzeit
	 * 
	 * @param date
	 *            Datum
	 * @param time
	 *            Uhzeit
	 * @return Date-Entity
	 * @throws ParseException
	 */
	public static Date createDate(String date, String time) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("d.M.yyyy-H:m");
		df.setLenient(false);
		return df.parse(date + "-" + time);
	}

	/**
	 * Erzeugt ein Dummy-Event aus einem Datum
	 * 
	 * @param date
	 *            das Datum des Dummy-Events
	 * @return das Dummy-Event
	 */
	public static Event fromDate(Date date) {
		return new Event(new Location("", ""), date, 1, 0, EventType.Dummy);
	}

	public enum EventType {
		Performance,
		Practice,
		Dummy
	}
}
