package service;

/**
 * Login des Users und Verwalten der Rechte.
 * für Allgemeine Rechte gibt es enum rights; für User-spezifische Rechte den login-Namen
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
		//TODO: implement login
		Session.loginName = loginName;
		Session.userRights = rights.admin;
		return true;
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
