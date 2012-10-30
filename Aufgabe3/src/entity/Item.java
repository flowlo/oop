package entity;

import java.util.Date;
import java.util.List;

/**
 * Oberklasse fuer alles was mit Geld zu tun hat =)
 * 
 * @author Simon
 * @author Dominik
 * 
 */
public abstract class Item {
	/**
	 * Rechnungsbetrag in Cent
	 */
	protected int money = 0;

	/**
	 * Name/Beschreibung der Dienstleistung
	 */
	protected String comment = "";

	/**
	 * Rechnungszeitpunkt
	 */
	protected Date dateTime;

	/**
	 * Datensatz ist zum Loeschen markiert
	 */
	boolean deleted;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		save();
		this.money = money;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		save();
		this.comment = comment;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		save();
		this.dateTime = dateTime;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void delete() {
		setDeleted(true);
	}

	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * Speichert den aktuellen Zustand in der History
	 */
	protected abstract void save();

	/**
	 * Liefert ein bestimmtes History-Element
	 */
	public abstract Item getHistoryItem(int version);

	/**
	 * Gibt die History des Datensatzes zurueck
	 * 
	 * @return alle Versionen des Datensatzes
	 */
	public abstract List<?> getHistory();

	/**
	 * Reversiert den Datensatz zur angegebenen Version
	 * 
	 * @param version
	 */
	public abstract void revert(int version);

	/**
	 * Reversiert den Datensatz zum angegebenen Item
	 * 
	 * @param version
	 */
	public abstract void revert(Item version);
}
