package entity;

import java.util.Date;

/**
 * Ein Bandmitglied.
 * 
 * @author Lorenz
 */
public class Member extends User {
	/**
	 * Telefonnummer des Bandmitglieds.
	 */
	private String phoneNumber;

	/**
	 * Instrument, dass das Mitglied in der Band spielt.
	 */
	private String instrument;

	protected Date start;
	protected Date end;

	/**
	 * Erzeugt ein neues Mitglied einer Band mit angegebenen Eigenschaften.
	 * 
	 * @param name
	 *            Name des Mitglieds
	 * @param phoneNumber
	 *            Telefonnummer des Mitglieds.
	 * @param instrument
	 *            Instrument, dass das Mitglied in der Band spielt.
	 */
	public Member(String loginName, String firstName, String lastName, String pwd, String phoneNumber, String instrument) {
		super(loginName, pwd);
		this.start = new Date();
		this.phoneNumber = phoneNumber;
		this.instrument = instrument;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gibt die Telefonnummer des Bandmitglieds zurueck.
	 * 
	 * @return die Telefonnummer des Bandmitglieds
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gibt den Namen des Instruments zurueck, dass das Mitglied spielt.
	 * 
	 * @return den Namen des Instruments
	 */
	public String getInstrument() {
		return instrument;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " (" + phoneNumber + ") spielt(e) von " + start + " bis "
				+ (end != null ? end : "jetzt") + " " + instrument + ".";
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

	public void deactivate()
	{
		end = new Date();
	}
}
