package service;

import dao.DaoException;
import dao.TestUserDao;
import dao.UserDao;
import entity.User;

/**
 * Login des Users und Verwalten der Rechte.
 * fuer Allgemeine Rechte gibt es enum rights; fuer User-spezifische Rechte den login-Namen
 * 
 * @author Simon
 * 
 */
public class Session {

	/**
	 * allgemeine Rechte (Admin, Musiker, Buchhaltung)
	 * 
	 * @author Simon
	 * 
	 */
	public enum rights {
		admin, member, staff, none
	};

	private Session()
	{

	}

	private static UserDao userDao = new TestUserDao();
	private static rights userRights = rights.none;
	private static String loginName = null;

	/**
	 * Einloggen eines Nutzers
	 * 
	 * @param loginName
	 *            des Nutzers (key)
	 * @param pwd
	 *            Passwort
	 * @return true wenn erfolgreich; null sonst
	 */
	public static boolean login(String loginName, String pwd)
	{
		try {
			User user = userDao.getUser(loginName);
			if (user == null) {
				return false;
			}
			if (user.checkPwd(pwd))
			{
				Session.loginName = loginName;
				Session.userRights = user.getRights();
				return true;
			}
		} catch (DaoException e) {
			return false;
		}

		return false;

	}

	/**
	 * Abmelden
	 */
	public static void logout()
	{
		userRights = rights.none;
		loginName = null;
	}

	/**
	 * to validate public rights
	 * 
	 * @return rights of the user
	 */
	public static rights getRights()
	{
		return userRights;
	}

	/**
	 * To validate private rights
	 * 
	 * @return login name of the user
	 */
	public static String getLoginName()
	{
		return loginName;
	}

}
