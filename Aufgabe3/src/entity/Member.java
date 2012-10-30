package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.Session;

public class Member extends User {

	private String phoneNumber;

	private String instrument;

	private List<String> messages = new ArrayList<String>();

	private Date start;
	private Date end;

	private String band;

	/*
	 * Nachbedingung: legt ein Mitglied mit gueltigen Attributen an 
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getInstrument() {
		return instrument;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " (" + phoneNumber + ") spielt(e) von " + start + " bis "
				+ (end != null ? end : "jetzt") + " " + instrument + ".";
	}

	/*
	 * Vorbedingung: keine
	 * Nachbedingung: keine
	 * Verhalten: gibt an, ob das Mitglied zum gegebenen Datum aktiv war/ist
	 * FEHLER: date wir nicht geprueft
	 */
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

	//Nachbedingung: Mitglied ist mit aktuellem Datum nicht mehr aktiv
	public void deactivate() {
		end = new Date();
	}

	//Nachbedingung: Nachricht wird gespeichert
	public void addMessage(String message) {
		messages.add(message);
	}

	//Nachbedingung: Alle Nachrichten sind geloescht
	public List<String> getMessages() {
		List<String> tempMessages = new ArrayList<String>(messages);
		messages = new ArrayList<String>();
		return tempMessages;
	}
}
