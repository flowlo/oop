package entity;

import java.util.Date;

/**
 * Basisklasse f�r Member und Titel
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
	 * das Mitglied/das St�ck wird mit dem aktuellen Datum als gel�scht markiert
	 */
	public void delete()
	{
		this.end = new Date(System.currentTimeMillis());
	}

	/**
	 * Pr�ft, ob das Mitglied/das St�ck zum gegebenen Zeitpunkt aktiv war
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
