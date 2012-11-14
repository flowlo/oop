/*
	ClearBox ist ein Untertyp von Box
		* Zeichen fuer den Rand von ClearBox ist nicht ' '
		* Zeichen bleiben unveraendert

	Box ist kein Untertyp von ClearBox, da das Seitenverhaeltnis nicht abgefragt werden kann.
	
	DarkBox ist kein Untertyp von Box, da das Zeichen nachtraeglich geeandert werden kann.
	
	Box ist kein Untertyp von DarkBox, da das Zeichen nicht nachtraeglich geeandert werden kann.
	
	FreeBox ist kein Untertyp von Box, da hier nicht zwei Zeichen fuer den Inhalt bzw. Rahmen verwendet werden.
	
	Box ist kein Untertyp von FreeBox, da es anders skaliert.
	
	Repeated<P> fuer unbekannte P ist kein Untertyp von Box, da nicht genau zwei Zeichen fuer Rand und Inneres verwendet werden.
	
	Box ist kein Untertyp von Repeated<P> fuer unbekannte P, da es anders skaliert.
	
	Repeated<P> fuer jeden einzelnen Untertyp P von Pict ist kein Untertyp von Box, da nicht genau zwei Zeichen fuer Rand und Inneres verwendet werden.
	
	Box ist kein Untertyp von Repeated<P> fuer jeden einzelnen Untertyp P von Pict, da es anders skaliert.
	
	Repeated und Scaled sind keine Boxen weil es Container sind.
	Veraendert man eine Box die in dem Container gespeichert ist veraendert sich auch die Ausgabe des Containers.
	Die Ausgabe einer Box kann sich aber nur durch box.scale() aendern
*/

public class Test {
	public static void main(String[] args) {

		System.out.println("Erstellen von Boxen: ");

		Box b1 = new Box(3, 5, 'o', '*');
		ClearBox cb = new ClearBox(4, 4);
		DarkBox db = new DarkBox(6, 3, 'o');
		FreeBox fb = new FreeBox(new String("12345\n12345\n12345"));

		System.out.println("Box: 3x5");
		System.out.println(b1);
		System.out.println("ClearBox: 4x4");
		System.out.println(cb);
		System.out.println("DarkBox: 6x3");
		System.out.println(db);
		System.out.println("FreeBox: 3x5");
		System.out.println(fb);

		System.out.println("Erstelle ein AbstractBox[][] aus den Boxen + 2 neuen (die neuen sind links)");
		AbstractBox[][] boxes = new AbstractBox[][] {
				new AbstractBox[] { new ClearBox(1, 1), b1, cb },
				new AbstractBox[] { new ClearBox(5, 5), db, fb }
		};
		System.out.println("Erstelle aus den AbstractBox[][] ein Scaled<AbstracBox>");

		Scaled<AbstractBox> s = new Scaled<AbstractBox>(boxes);
		System.out.println(s);
		System.out.println("rufe scaled.scale(2) auf");
		s.scale(2);
		System.out.println(s);
		System.out.println("rufe scaled.scale(0.5) auf");
		s.scale(0.5);
		System.out.println(s);

		System.out
				.println("Die groesse eines Scaled kann sich aendern obwohl nicht scaled.scale aufgerufen wird: (durch Aufruf von scale eines Objekts im Container)");
		System.out
				.println("Wir sehen es als zusicherung einer Box, dass sich die groesse nur durch scale() aendern kann. Daher ist scaled keine Box");
		db.scale(0.5);
		System.out.println(s);

		System.out.println("Erzeuge ein Repeated<Object> aus einem String, dem Scaled und weiteren Boxen: ");
		Object[][] array = new Object[][]
		{
				new Object[] { new String("Ein String"), s, new DarkBox(7, 2, '+') },
				new Object[] { b1, cb, new String("Ein String") },
		};
		Repeated<Object> r = new Repeated<Object>(array);
		System.out.println(r);

		System.out.println("Deklariere ein Pict");
		Pict pict;
		System.out.println("Initialisiere pict mit DarkBox 2x2");
		pict = new DarkBox(4, 4, 'O');
		System.out
				.println("Ueber pict koennen jetzt nur scale und toString aufgerufen werden - nicht setCharacter der DarkBox (rufe scale(1,8) auf und toString)");
		pict.scale(1.8);
		System.out.println(pict);
		System.out.println("Nach Cast zu DarkBox kann der Character geandert werden:");
		((DarkBox) pict).setCharacter('X');
		System.out.println(pict);

		try
		{
			((ClearBox) pict).getAspectRatio();
		} catch (ClassCastException e)
		{
			System.out.println("Ein Cast zu (zB) ClearBox wirft aber eine ClassCastException: " + e.getMessage());
		}

		System.out.println("Andere Boxen verhalten sich analog.");
	}
}
