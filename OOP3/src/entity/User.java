package entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.Session;

/**
 * @author Simon
 */
public class User {

	protected String loginName, firstName, lastName, pwd;
	protected Session.rights rights;

	/*
	 * Vorbedingung: keine
	 * Nachbedingung: Gueltiger User erstellt
	 * FEHLER: firstName, lastName nicht gesetzt.. get-Methoden liefern null zurueck (war nicht so geplant)
	 */
	public User(String loginName, String pwd)
	{
		this.setPwd(pwd, false);
		this.loginName = loginName;
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

	/*
	 * Vorbedingung: keine
	 * Verhalten: vergleicht das uebergebene Passwort mit dem Passwort des Useres
	 */
	public boolean checkPwd(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			pwd = new String(md.digest(pwd.getBytes()));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return this.pwd.equals(pwd);
	}

	/*
	 * Vorbedingung: keine
	 * Nachbedingung: Passwor fuer User gesetzt
	 * Verhalten: speichert ein verschluesseltes Passwort
	 */
	public void setPwd(String pwd, boolean isHash) {
		if (!isHash)
		{
			try {
				MessageDigest md = MessageDigest.getInstance("SHA");
				pwd = new String(md.digest(pwd.getBytes()));

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		this.pwd = pwd;

	}

	public Session.rights getRights() {
		return rights;
	}

	public void setRights(Session.rights rights) {
		this.rights = rights;
	}

}
