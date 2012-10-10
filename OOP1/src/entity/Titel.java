package entity;

import java.util.Date;


/**
 * Ein Titel/ein Song
 * @author Simon
 *
 */
public class Titel extends BandObject {
	private int length;
	
	public Titel(String name, int length)
	{
		this.name=name;
		this.length=length;
		this.start=new Date(System.currentTimeMillis());
		this.end=null;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

}
