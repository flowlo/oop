package dao;

import entity.User;

public interface UserDao {
	/**
	 * Einen User aus der Datenbank auslesen
	 * 
	 * @param loginName
	 *            = key
	 * @return User mit loginName; null wenn nicht gefunden
	 * @throws DaoException
	 *             Exception wenn zb keine Verbindung zur Datenbank hergestellt werden kann
	 */
	public User getUser(String loginName) throws DaoException;

	/**
	 * Speichert den User in die Datenbank
	 * 
	 * @param user
	 *            zu speichernder User
	 * @throws DaoException
	 *             Exception wenn zb keine Verbindung zur Datenbank hergestellt werden kann
	 */
	public void createUser(User user) throws DaoException;

	/**
	 * Löscht den User
	 * 
	 * @param loginName
	 *            des zu löschenden Users
	 * @throws DaoException
	 *             Exception wenn zb keine Verbindung zur Datenbank hergestellt werden kann
	 */
	public void deleteUser(String loginName) throws DaoException;
}
