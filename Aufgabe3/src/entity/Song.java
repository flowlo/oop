package entity;

/**
 * @author Lorenz
 */
//SCHLECHT: Song ist das einzige BandObject (früher hat Member geerbt)
public class Song extends BandObject {

	private int duration;

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
