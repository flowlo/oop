package entity;

import java.util.Date;

/**
 * Ein Bandmitglied
 * @author Simon
 *
 */
public class Member extends BandObject {
	private String phoneNumber;
	private String instrument;
	
	public Member(String name, String phoneNumber, String instrument)
	{
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.instrument=instrument;
		this.end=null;
		this.start=new Date(System.currentTimeMillis());
	}
	
	

	

	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getInstrument()
	{
		return instrument;
	}
	
}
