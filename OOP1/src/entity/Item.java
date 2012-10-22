package entity;

import java.util.Date;

/**
 * Oberklasse für alles was mit Geld zu tun hat =)
 * 
 * @author Simon
 * 
 */
public class Item {
	/**
	 * Rechnungsbetrag in Cent
	 */
	protected int money;

	/**
	 * Name/Beschreibung der Dienstleistung
	 */
	protected String comment;

	/**
	 * Rechnungszeitpunkt
	 */
	protected Date dateTime;
}
