package entity;

import java.util.Date;

/**
 * Ein Bandmitglied
 * @author Simon, Lorenz
 */
public final class Member extends BandObject {
	/**
	 * Telefonnummer des Bandmitglieds.
	 */
	private final String phoneNumber;

	/**
	 * Instrument, dass das Mitglied in der Band spielt.
	 */
	private final String instrument;

	/**
	 * Erzeugt ein neues Mitglied einer Band mit angegebenen Eigenschaften.
	 * @param name Name des Mitglieds
	 * @param phoneNumber Telefonnummer des Mitglieds.
	 * @param instrument Instrument, dass das Mitglied in der Band spielt.
	 */
	public Member(final String name, final String phoneNumber, final String instrument)
	{
		this.name=name;
		this.phoneNumber = phoneNumber;
		this.instrument = instrument;
		this.start = new Date();
		this.end = null;
	}

	/**
	 * Gibt die Telefonnummer des Bandmitglieds zurueck.
	 * @return die Telefonnummer des Bandmitglieds
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Gibt den Namen des Instruments zurueck, dass das Mitglied spielt.
	 * @return den Namen des Instruments
	 */
	public String getInstrument()
	{
		return instrument;
	}
	
	
	public String toString()
	{
		String result=new String("Name: '"+name+"' Tel.: '"+phoneNumber+"' Instrument: '"+instrument+"'"+" spielt(e) von '"+start+"' bis ");
		if(end==null) result+="jetzt";
		else result+="'"+end+"'";
		return result;
	}
}
