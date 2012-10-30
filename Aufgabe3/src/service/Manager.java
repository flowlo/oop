package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import service.Session.rights;
import dao.DaoException;
import dao.TestUserDao;
import dao.UserDao;
import entity.Member;
import entity.User;

public class Manager {
	private UserDao userDao = new TestUserDao();
	private HashMap<String, BandManager> bands = new HashMap<String, BandManager>();

	/*
	 * Nachbedingung: Standard-User angelegt (testzwecke da keine feste Datenbank)
	 */
	public Manager() {
		User user = new User("admin", "password");
		user.setRights(rights.admin);
		try {
			userDao.createUser(user);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Vorbedingung: Benutzer hat notwendige Rechte
	 * Nachbedingung: Band ist gespeichert
	 */
	public BandManager createBand(String name) throws ServiceException {
		if (Session.getRights() != rights.admin) {
			throw new ServiceException("ERROR - Admin rights required");
		}

		if (bands.containsKey(name)) {
			return null;
		}

		BandManager result = new BandManager(name);
		bands.put(name, result);
		return result;
	}

	/*
	 * Vorbedingung: Benutzer hat notwendige Rechte
	 * SCHLECHT: Inkonsistente Rechte-Behandlung (create Band wirft exception - hier wird null zurueck gegeben)
	 */
	public Set<String> getAllBands() {
		if (Session.getRights() == rights.none) {
			return null;
		}
		return bands.keySet();
	}

	/*
	 * Vorbedingung: Band existiert, Benutzer hat Rechte
	 * "SCHLECHT": getAllBands() kann hier durch Brute-Force erhalten werden
	 */
	public BandManager getBand(String name) throws ServiceException {
		BandManager band = bands.get(name);
		if (band == null) {
			throw new ServiceException("WARNING - No such band");
		}

		Collection<Member> members = band.listMembers();

		if (Session.getRights() != rights.admin)
		{
			boolean access = false;
			for (Member it : members)
			{
				if (it.getLoginName().equals(Session.getLoginName())) {
					access = true;
				}
			}
			if (!access) {
				throw new ServiceException("ERROR - You are not a member of this band");
			}
		}
		return band;
	}

	/*
	 * Vorbedingung: Benutzer hat notwendige Rechte
	 * FEHLER: Rechtepruefung wurde nicht implementiert
	 */
	public void deleteUser(String loginName) {
		try {
			new TestUserDao().deleteUser(loginName);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public String getCurrentUser() {
		return Session.getLoginName();
	}

	/*
	 * Vorbedingung: keine
	 * Nachbedingung: User ist angemeldet (oder nicht bei falschen login-Daten)
	 */
	public boolean login(String user, String pwd) {
		return Session.login(user, pwd);
	}

	public void logout() {
		Session.logout();
	}
}
