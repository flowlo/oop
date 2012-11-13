/*
	ClearBox ist ein Untertyp von Box
		* Zeichen fuer den Rand von ClearBox ist nicht ' '
		* Zeichen bleiben unveraendert

	Box ist kein Untertyp von ClearBox, da das Seitenverhaeltnis nicht abgefragt werden kann.
	
	DarkBox ist kein Untertyp von Box, da das Zeichen nachtraeglich geeandert werden kann.
	
	Box ist kein Untertyp von DarkBox, da das Zeichen nachtraeglich geeandert werden kann.
	
	FreeBox ist kein Untertyp von Box, da hier nicht zwei Zeichen fuer den Inhalt bzw. Rahmen verwendet werden.
	
	Box ist kein Untertyp von FreeBox, da es anders skaliert.
	
	Repeated<P> für unbekannte P ist kein Untertyp von Box, da nicht genau zwei Zeichen für Rand und Inneres verwendet werden.
	
	Box ist kein Untertyp von Repeated<P> für unbekannte P, da es anders skaliert.
	
	Repeated<P> für jeden einzelnen Untertyp P von Pict ist kein Untertyp von Box, da nicht genau zwei Zeichen für Rand und Inneres verwendet werden.
	
	Box ist kein Untertyp von Repeated<P> für jeden einzelnen Untertyp P von Pict, da es anders skaliert.
*/

public class Test {
	public static void main(String[] args) {
		Pict[][] picts = new Pict[][] {
				new Pict[] { new Box(3, 3), new ClearBox(4, 4), new DarkBox(3, 5, '~'), new Box(6, 6), new ClearBox(7, 5) },
				new Pict[] { new DarkBox(7, 6, 'X'), new Box(4, 4), new ClearBox(3, 5), new Box(7, 2), new Box(2, 2) },
				new Pict[] { new Box(1, 1), new Box(1, 2), new Box(2, 1), new Box(2, 2), new ClearBox(2, 2)},
				new Pict[] { new Box(3, 3), new ClearBox(4, 4), new DarkBox(3, 5, '~'), new Box(6, 6), new ClearBox(7, 5) },
				new Pict[] { new DarkBox(7, 6, 'X'), new Box(4, 4), new ClearBox(3, 5), new Box(7, 2), new Box(2, 2) },
			};
		
		Pict free = new FreeBox("1234\n5678");
		free.scale(1.5);
		System.out.println(free);
		
		Repeated<Pict> r = new Repeated<Pict>(picts);
		System.out.println(r.toString());
	}
}
