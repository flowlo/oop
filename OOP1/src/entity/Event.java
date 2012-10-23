package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Repraesentiert sowohl eine Probe, als auch einen Auftritt
 * 
 * @author Dominik
 */
public class Event extends Item implements Comparable<Event> {
	/**
	 * Ort der Veranstaltung (Probe/Auftritt).
	 */
	private Location place;

	/**
	 * Dauer dieses Events in Sekunden.
	 */
	private int duration;

	/**
	 * Typ dieses Events, um zwischen Probe und Auftritt zu unterscheiden.
	 */
	private EventType type;

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
	public Event(Location place, Date date, int duration, int money,
			EventType type) {
		this.place = place;
		this.dateTime = date;
		this.duration = duration;
		this.money = money;
		this.type = type;
	}

	public Location getPlace() {
		return place;
	}

	public Date getDate() {
		return dateTime;
	}

	public int getDuration() {
		return duration;
	}

	public float getMoney() {
		return money;
	}

	@Override
	public int compareTo(Event o) {
		return dateTime.compareTo(o.getDate());
	}

	public static Event fromDate(Date date) {
		return new Event(new Location("", ""), date, 1, 0, EventType.Dummy);
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
	public static Event toEvent(Location place, String date, String time, int duration, int money, EventType type) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("d.M.yyyy-H:m");
		df.setLenient(false);
		Date datetime = df.parse(date + "-" + time);
		return new Event(place, datetime, duration, money, type);

	}

	public enum EventType {
		Performance,
		Practice,
		Dummy
	}
}
