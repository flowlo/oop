package entity;

/**
 * @author Lorenz
 */
//SCHLECHT: Song ist das einzige BandObject (frueher hat Member geerbt)
public class Song extends BandObject {

	private int duration;

	/* Vorbedingung: keine
	 * Nachbedingung: alle Werte des Objekts gueltig (erfuellt durch BandObject)
	 */
	public Song(String name, int length) {
		super(name);
		this.duration = length;
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return name + "(" + duration + "s)";
	}
}
