import java.util.ArrayList;

/**
 * Die Testklasse testet den Code der OOP-Abgabe 9.
 * 
 * Es waere moeglich gewesen, Teif, Fuellung und Form durch Vererbungsbeziehungen darzustellen.
 * Darauf wurde jedoch verzichtet, um die Anzahl der Klassen gering zu halten. Die Repraesentation
 * durch enums ist weit wartbarer bei der vorliegenden Aufgabenstellung.
 * 
 * Weiters bitte den Kommentar in Keksbackmaschine.java beruecksichtigen.
 * 
 * @author Simon
 * 
 */
public class Test {
	public static void main(String args[]) {
		Baeckerei BaeckereiGlueck = new Baeckerei();

		ArrayList<Position> liste = new ArrayList<Position>();
		liste.add(new Position(3, Form.RUND, Teigart.MUERB, null));
		Bestellung b1 = new Bestellung(liste);

		System.out.println("STARTE TESTS");
		System.out.print("Versuche Keks mit einer Form zu Backen, fuer welche die Baeckerei keine Maschine hat... ");
		try {
			BaeckereiGlueck.produziere(b1);
			System.out.println("FAILED");
		} catch (BackmaschineNichtVorhandenException e) {
			System.out.println("PASSED");
		}
		//-----------------------------------------------------------------------------------
		System.out.println("(Fuege alle Maschinen der Baeckerei hinzu)");
		BaeckereiGlueck.addMaschine(Form.MOND);
		BaeckereiGlueck.addMaschine(Form.RUND);
		BaeckereiGlueck.addMaschine(Form.WEIHNACHTSMANN);

		//-----------------------------------------------------------------------------------
		System.out.println("\nErstelle Bestellung 1");
		liste.add(new Position(2, Form.WEIHNACHTSMANN, Teigart.SCHOKOLADE, null));
		liste.add(new Position(4, Form.MOND, Teigart.ZIMTSTERN, Fuellung.SCHOKOLADE));
		b1 = new Bestellung(liste);
		b1.drucke();

		try {
			Keksdose dose = BaeckereiGlueck.produziere(b1);
			System.out.println("\nKeksdose wurde erzeugt: ");
			dose.inhalt();
		} catch (BackmaschineNichtVorhandenException e) {
			System.out.println("FAILED");
		}
		//-----------------------------------------------------------------------------------
		System.out.println("\nErstelle Bestellung 2");
		liste = new ArrayList<Position>();
		liste.add(new Position(2, Form.RUND, Teigart.SCHOKOLADE, Fuellung.MARMELADE));
		liste.add(new Position(3, Form.MOND, Teigart.ZIMTSTERN, Fuellung.SCHOKOLADE));
		b1 = new Bestellung(liste);
		b1.drucke();

		try {
			Keksdose dose = BaeckereiGlueck.produziere(b1);
			System.out.println("\nKeksdose wurde erzeugt: ");
			dose.inhalt();
		} catch (BackmaschineNichtVorhandenException e) {
			System.out.println("FAILED");
		}
		//-----------------------------------------------------------------------------------
		System.out.println("\nErstelle Bestellung 3");
		liste = new ArrayList<Position>();
		liste.add(new Position(2, Form.WEIHNACHTSMANN, Teigart.MUERB, Fuellung.MARMELADE));
		liste.add(new Position(1, Form.RUND, Teigart.ZIMTSTERN, Fuellung.SCHOKOLADE));
		liste.add(new Position(1, Form.MOND, Teigart.SCHOKOLADE, Fuellung.MARMELADE));
		liste.add(new Position(1, Form.RUND, Teigart.MUERB, null));
		liste.add(new Position(1, Form.MOND, Teigart.ZIMTSTERN, Fuellung.SCHOKOLADE));
		liste.add(new Position(1, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERN, null));
		b1 = new Bestellung(liste);
		b1.drucke();

		try {
			Keksdose dose = BaeckereiGlueck.produziere(b1);
			System.out.println("\nKeksdose wurde erzeugt: ");
			dose.inhalt();
		} catch (BackmaschineNichtVorhandenException e) {
			System.out.println("FAILED");
		}
		//-----------------------------------------------------------------------------------
	}
}
