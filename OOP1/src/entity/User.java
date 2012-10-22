package entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.Session;

/**
 * Basisklasse für alle Nutzer
 * 
 * @author Simon
 * 
 */
public class User {

	protected String loginName, firstName, lastName, pwd;
	protected Session.rights rights;

	//TODO: implementierung
	public User()
	{
		this.rights = Session.rights.none;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean checkPwd(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			pwd = new String(md.digest(pwd.getBytes()));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.pwd.equals(pwd);
	}

	/**
	 * 
	 * @param pwd
	 *            Passwort
	 * @param isHash
	 *            true, wenn das Passwort bereits verschlüsselt ist, false wenn es verschlüsselt werden soll
	 */
	public void setPwd(String pwd, boolean isHash) {
		if (!isHash)
		{
			try {
				MessageDigest md = MessageDigest.getInstance("SHA");
				pwd = new String(md.digest(pwd.getBytes()));

			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.pwd = pwd;

	}

	/**
	 * @return the rights
	 */
	public Session.rights getRights() {
		return rights;
	}

	/**
	 * @param rights
	 *            the rights to set
	 */
	public void setRights(Session.rights rights) {
		this.rights = rights;
	}

}
