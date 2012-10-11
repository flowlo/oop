package entity;

import java.util.Date;

/**
 * Ein Song aus dem Repertoire der Band.
 * 
 * @author Lorenz
 */
public class Song extends BandObject {
	/**
	 * Laenge des Musikstuecks in Sekunden.
	 */
	private int length;

	/**
	 * Initialisiert ein neues Musikstueck mit Name und Laenge.
	 * 
	 * @param name
	 *            der Titel des Musikstuecks
	 * @param length
	 *            die Abspieldauer des Songs
	 */
	public Song(String name, int length) {
		this.name = name;
		this.length = length;
		this.start = new Date();
		this.end = null;
	}

	/**
	 * @return Die Abspieldauer des Songs in Sekunden
	 */
	public int getLength() {
		return length;
	}
}
