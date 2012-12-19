import java.util.List;

/**
 * Eine Bestellung enthaelt eine Liste von Positionen, die beschreibt, was fuer Kekse
 * in welcher Anzahl gekauft werden. Weiters kann aus der Bestellung eine Keksdose
 * generiert werden.
 * 
 * Zusicherungen:
 * Generierte Keksdosen enthalten alle Kekse der Positionen.
 * 
 * @author Dominik
 * 
 */
public class Bestellung {
	private List<Position> positionen;

	public Bestellung(List<Position> positionen) {
		super();
		this.positionen = positionen;
	}

	public List<Position> getPositionen()
	{
		return positionen;
	}

	/**
	 * Schreibt die Bestellung und all ihre Positionen in die Standardausgabe.
	 */
	public void drucke() {
		System.out.println("Bestellung mit folgenden Keksen: ");
		for (Position p : positionen)
		{
			System.out.println(" - " + p.toString());
		}
	}
}
