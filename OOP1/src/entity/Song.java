package entity;


/**
 * Ein Song aus dem Repertoire der Band.
 * 
 * @author Lorenz
 */
public class Song extends BandObject {
	/**
	 * Laenge des Musikstuecks in Sekunden.
	 */
	private int duration;

	/**
	 * Initialisiert ein neues Musikstueck mit Name und Laenge.
	 * 
	 * @param name
	 *            der Titel des Musikstuecks
	 * @param length
	 *            die Abspieldauer des Songs
	 */
	public Song(String name, int length) {
		super(name);
		this.duration = length;
	}

	/**
	 * @return Die Abspieldauer des Songs in Sekunden
	 */
	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return name + "(" + duration + "s)";
	}
}
