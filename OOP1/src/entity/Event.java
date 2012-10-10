package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Repräsentiert sowohl eine Probe, als auch einen Auftritt
 * 
 * @author Dominik
 * 
 */
public class Event implements Comparable<Event> {
	private String place;
	private Date dateTime;//date+time
	private int duration;//seconds
	private float money; //Kosten und Einnahmen
	private EventType type;

	/**
	 * Neues Event erstellen
	 * 
	 * @param place
	 *            Ort der Veranstaltung
	 * @param date
	 *            Datum + Uhrzeit
	 * @param duration
	 *            Dauer in Minuten
	 * @param money
	 *            Kosten/Gage
	 * @param type
	 *            typ des Events
	 */
	public Event(String place, Date date, int duration, float money, EventType type)
	{
		this.place = place;
		this.dateTime = date;
		this.duration = duration;
		this.money = money;
		this.type = type;
	}

	public String getPlace()
	{
		return place;
	}

	public Date getDate()
	{
		return dateTime;
	}

	public int getDuration()
	{
		return duration;
	}

	public float getMoney()
	{
		return money;
	}

	@Override
	public int compareTo(Event o) {
		return dateTime.compareTo(o.getDate());
	}

	public static Event getFromDate(Date date) {
		return new Event("", date, 1, 0, EventType.Performance);
	}

	@Override
	public String toString() {
		String typeString = "Termin";
		String moneyString = "Geld";
		if (type.equals(EventType.Performance)) {
			typeString = "Auftritt";
			moneyString = "Gage";
		}
		else if (type.equals(EventType.Practice)) {
			typeString = "Probe";
			moneyString = "Miete";
		}

		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return typeString + " - Datum: " + df.format(dateTime) + " - Dauer: " + duration + " Minuten - " + moneyString + ": " + money;
	}
}
