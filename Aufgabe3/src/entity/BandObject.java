package entity;

import java.util.Date;

/**
 * @author Lorenz
 */
// SCHLECHT: Sollte geloescht werden, da nur noch Song davon erbt. Frueher hat auch Member geerbt, was aber entfernt wurde
public abstract class BandObject {
	protected String name;
	protected Date start;
	protected Date end;

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Alle werte des Objekts sind gefuellt
	 */
	protected BandObject(String name, Date start, Date end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}

	/*
	 * Vorbedingung:
	 * Nachbedingung: BandObject hat kein Enddatum, Name ist übernommen
	 */
	protected BandObject(String name) {
		this(name, new Date(), null);
	}

	public String getName()
	{
		return name;
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: BandObject ist nciht mehr aktiv
	 */
	public void deactivate()
	{
		end = new Date();
	}

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
