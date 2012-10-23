package entity;

import java.util.Date;
import java.util.List;

/**
 * Oberklasse für alles was mit Geld zu tun hat =)
 * 
 * @author Simon
 * @author Dominik
 * 
 */
public abstract class Item {
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

	protected abstract void save();

	public abstract List<?> getHistory();

	public abstract Item getHistoryItem(int version);

	public abstract void revert(int version);

	public abstract void revert(Item version);

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void delete() {
		setDeleted(false);
	}

	public boolean isDeleted() {
		return deleted;
	}
}
