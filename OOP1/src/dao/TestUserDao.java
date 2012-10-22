package dao;

import java.util.HashMap;

import entity.User;

public class TestUserDao implements UserDao {

	private static HashMap<String, User> users = new HashMap<String, User>();

	@Override
	public User getUser(String loginName) throws DaoException {
		return users.get(loginName);
	}

	@Override
	public void createUser(User user) throws DaoException {
		users.put(user.getLoginName(), user);

	}

	@Override
	public void deleteUser(String loginName) throws DaoException {
		users.remove(loginName);

	}

}
