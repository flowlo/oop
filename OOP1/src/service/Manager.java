package service;

import java.util.Collection;
import java.util.HashMap;

import service.Session.rights;
import dao.DaoException;
import dao.TestUserDao;
import dao.UserDao;
import entity.Member;
import entity.User;

//---
public class Manager {
	private UserDao userDao = new TestUserDao();
	private HashMap<String, BandManager> bands = new HashMap<String, BandManager>();

	public Manager()
	{
		User user = new User("admin", "password");
		user.setRights(rights.admin);
		try {
			userDao.createUser(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Legt eine neue Band mit dem Namen an
	 * 
	 * @param name
	 *            der Band
	 * @return BandManger zum Verwalten der Band
	 * @throws ServiceException
	 *             wirft Exception, wenn nicht als Admin angemeldet
	 */
	public BandManager createBand(String name) throws ServiceException
	{
		if (Session.getRights() != rights.admin) {
			throw new ServiceException("ERROR - Admin rights required");
		}

		if (bands.containsKey(name)) {
			return null;
		}

		BandManager result = new BandManager();
		bands.put(name, result);
		return result;
	}

	public BandManager getBand(String name) throws ServiceException
	{
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

	public boolean login(String user, String pwd)
	{
		return Session.login(user, pwd);
	}
}
