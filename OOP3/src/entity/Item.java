package entity;

import java.util.Date;
import java.util.List;

/**
 * @author Simon
 * @author Dominik
 */
// SCHLECHT: Diese Klasse wurde fuer die History mirrbaucht, obwohl sie nie dafuer gedacht war. Die Vererbung hat halt gestimmt.
// Besser ein neues History-Interface definieren
public abstract class Item {
	protected int money = 0;
	protected String comment = "";
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

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void delete() {
		setDeleted(true);
	}

	public boolean isDeleted() {
		return deleted;
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Objekt ist in der History zu finden
	 */
	protected abstract void save();

	/*
	 * Vorbedingung: Version ist in der History zu finden
	 * Nachbedingung: Keine
	 */
	public abstract Item getHistoryItem(int version);

	public abstract List<?> getHistory();

	/*
	 * Vorbedingung: Version ist in der History zu finden
	 * Nachbedingung: Objekt entspricht der eingegebenen Version
	 * SCHLECHT: Sollte eine Exception werfen, wenn Version nicht vorhanden.
	 */
	public abstract void revert(int version);

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Objekt entspricht der eingegebenen Version
	 * SCHLECHT: revert ist der falsche Name. Es kann auch ein neues Objekt uebergeben werden.
	 */
	public abstract void revert(Item version);
}
