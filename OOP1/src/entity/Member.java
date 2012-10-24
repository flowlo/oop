package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.Session;

/**
 * Ein Bandmitglied.
 * 
 * @author Lorenz
 * @author Dominik
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

	/**
	 * Speichert die Nachrichten fuer das Mitglied
	 */
	private List<String> messages = new ArrayList<String>();

	private Date start;
	private Date end;

	private String band;

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
		this.rights = Session.rights.member;
	}

	public void setBand(String band)
	{
		this.band = band;
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

	public boolean isActive(Date date) {
		if (date.before(start)) {
			return false;
		} else if (end == null) {
			return true;
		} else if (date.after(start) && date.before(end)) {
			return true;
		}
		return false;
	}

	public void deactivate() {
		end = new Date();
	}

	public void addMessage(String message) {
		messages.add(message);
	}

	public List<String> getMessages() {
		List<String> tempMessages = new ArrayList<String>(messages);
		messages = new ArrayList<String>();
		return tempMessages;
	}
}
