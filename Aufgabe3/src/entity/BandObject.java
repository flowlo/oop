package entity;

import java.util.Date;

/**
 * Basisklasse fuer Member und Titel.
 * 
 * @author Lorenz
 */
public abstract class BandObject {
	protected String name;
	protected Date start;
	protected Date end;

	/**
	 * Initialisiert ein Objekt mit angegebenem Namen sowie Gueltigkeitszeitraum.
	 * 
	 * @param name
	 *            Name des Objekts
	 * @param start
	 *            Beginn der Gueltigkeit
	 * @param end
	 *            Ende der Gueltigkeit
	 */
	protected BandObject(String name, Date start, Date end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}

	/**
	 * Initialisiert ein neues Objekt mit unbeschraenkter Gueltigkeit ab dem Zeitpunkt des Aufrufs.
	 * 
	 * @param name
	 *            Name des Objekts
	 * @see #BandObject(String, Date, Date)
	 */
	protected BandObject(String name) {
		this(name, new Date(), null);
	}

	public String getName()
	{
		return name;
	}

	/**
	 * Das Mitglied/das Stueck wird mit dem aktuellen Datum als geloescht/inaktiv markiert
	 */
	public void deactivate()
	{
		end = new Date();
	}

	/**
	 * Prueft, ob das Mitglied/das Stueck zum gegebenen Zeitpunkt aktiv war.
	 * 
	 * @return {@code true} wenn {@code start < date < end}
	 */
	public boolean isActive(Date date)
	{
		if (date.before(start)) {
			return false;
		} else if (end == null) {
			return true;
		} else if (date.after(start) && date.before(end)) {
			return true;
		}
		return false;
	}
}
