package entity;

import java.util.Date;

/**
 * Basisklasse für Member und Titel
 * 
 * @author Lorenz
 * 
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
	 * das Mitglied/das Stück wird mit dem aktuellen Datum als gelöscht markiert
	 */
	public void delete()
	{
		this.end = new Date(System.currentTimeMillis());
	}

	/**
	 * Prüft, ob das Mitglied/das Stück zum gegebenen Zeitpunkt aktiv war
	 * 
	 * @return true wenn start<date<end
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
