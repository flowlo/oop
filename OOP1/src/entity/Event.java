package entity;

import java.util.Date;

/**
 * Repräsentiert sowohl eine Probe, als auch einen Auftritt
 * @author Simon
 *
 */
public class Event {
	private String place;
	private Date dateTime;//date+time
	private int duration;//seconds
	private float money; //Kosten und Einnahmen
	
	/**
	 * Neues Event erstellen (kann sowohl als Auftritt als auch als Probe verwendet werden - es wird nicht unterschieden)
	 * @param place Ort der Veranstaltung
	 * @param date	Datum + Uhrzeit 
	 * @param duration Dauer in Sekunden
	 * @param money Kosten/Gage
	 */
	public Event(String place, Date date,int duration,float money)
	{
		
	}
	
	public String getPlace()
	{
		return place;
	}
	
	public Date getDate()
	{
		return dateTime;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public float getMoney()
	{
		return money;
	}
	
}
