package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Dominik
 */
public class Event extends Item implements Comparable<Event> {
	private Location location;
	private int duration;
	private EventType type;
	private boolean canceled = false;
	private boolean confirmed = false;
	private List<Event> history = new ArrayList<Event>();
	private boolean blockSave = false;

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Objekt wurde erstellt
	 */
	public Event(Location location, Date dateTime, int duration, int money, EventType type) {
		this.location = location;
		this.dateTime = dateTime;
		this.duration = duration;
		this.money = money;
		this.type = type;
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Objekt wurde erstellt
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

	/*
	 * Bedingungen erfuellt
	 */
	@Override
	public void save() {
		if (!blockSave) {
			history.add(new Event(this));
		}
	}

	/*
	 * Bedingungen erfuellt
	 */
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

	/*
	 * Bedingungen erfuellt
	 */
	@Override
	public void revert(int version) {
		revert(getHistoryItem(version));
	}

	/*
	 * Bedingungen erfuellt
	 */
	@Override
	public void revert(Item version) {
		if (version != null) {
			if (version instanceof Event) {
				Event eventVersion = (Event) version;
				edit(eventVersion);
			}
		}
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Objekt wurde geaendert
	 */
	public void edit(Event event) {
		edit(event.getLocation(), event.getDateTime(), event.getDuration(), event.getMoney(), event.getType(), event.getComment(), event.isDeleted(),
				event.isCanceled());
	}

	/*
	 * Vorbedingung: Keine 
	 * Nachbedingung: Objekt wurde geaendert
	 * SCHLECHT: Hohe Objekt-Kopplung - viele Parameter. Man koennte Event als DTO verwenden
	 */
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
			dateInfo = "(bestaetigt)";
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

	public static Event toEvent(Location location, String date, String time, int duration, int money, EventType type) throws ParseException {
		return new Event(location, createDate(date, time), duration, money, type);
	}

	public static Date createDate(String date, String time) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("d.M.yyyy-H:m");
		df.setLenient(false);
		return df.parse(date + "-" + time);
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
