package service;

import dao.DaoException;
import dao.TestUserDao;
import dao.UserDao;
import entity.User;

/**
 * @author Simon
 * 
 */
public class Session {

	public enum rights {
		admin, member, staff, none
	};

	private Session()
	{

	}

	private static UserDao userDao = new TestUserDao();
	private static rights userRights = rights.none;
	private static String loginName = null;

	/*
	 * Vorbedingung: keine
	 * Nachbedingung: User ist angemeldet (oder nicht bei falschen login-Daten)
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

	/*
	 * Nachbedingung: es ist kein User mehr angemeldet und keine Rechte mehr vorhanden	 * 
	 */
	public static void logout()
	{
		userRights = rights.none;
		loginName = null;
	}

	public static rights getRights()
	{
		return userRights;
	}

	public static String getLoginName()
	{
		return loginName;
	}

}
