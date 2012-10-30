package dao;

import entity.User;

public interface UserDao {
	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Keine
	 * Verhalten: Gibt null zurueck, wenn user nicht gefunden 
	 */
	public User getUser(String loginName) throws DaoException;

	/*
	 * Vorbedingung: keine
	 * Nachbedingung: User ist angelegt und kann gefunden werden
	 * Fehlerfall: Exception wird geworden, wenn user schon existiert
	 */
	public void createUser(User user) throws DaoException;

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: User ist nicht in Datenbank zu finden
	 * BAD: (Anmerkung Dominik) Sollte Exception werfen, wenn User nicht vorhanden. Vorschlag Vorbedingung: User ist in Datenbank
	 * (Anmerkung Simon) Es sollte keine Exception geworfen werden, Nachbedingung ist erfüllt 
	 */
	public void deleteUser(String loginName) throws DaoException;
}
