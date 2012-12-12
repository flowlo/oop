import java.util.List;

/**
 * Eine Bestellung enthaelt eine Liste von Positionen, die beschreibt, was fuer Kekse
 * in welcher Anzahl gekauft werden. Weiters kann aus der Bestellung eine Keksdose
 * generiert werden.
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

	/**
	 * Generiert eine Keksdose aus der Bestellung
	 * 
	 * @return eine Keksdose, die alle bestellten Kekse beinhaltet
	 */
	public Keksdose getKeksdose() {
		return null;
	}

	/**
	 * Schreibt die Bestellung und all ihre Positionen in die Standardausgabe.
	 */
	public void drucke() {

	}
}
