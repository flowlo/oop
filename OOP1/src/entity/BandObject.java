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

	public String getName()
	{
		return name;
	}

	/**
	 * Das Mitglied/das Stueck wird mit dem aktuellen Datum als geloescht/inaktiv markiert
	 */
	public void delete()
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
