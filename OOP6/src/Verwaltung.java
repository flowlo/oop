import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Die Liste aus der Angabe (zur Speicherung der Androiden)
 * 
 * @author Dominik
 * @author Simon
 * 
 */
public class Verwaltung {

	private LinkedHashMap<Integer, ANAndroide> map;

	/**
	 * Kontruktor
	 */
	public Verwaltung()
	{
		map = new LinkedHashMap<Integer, ANAndroide>();
		//null ist standardmaessig drinnen... muss bei jeder Ausgabe weggenommen werden.
		map.put(null, null);
	}

	/**
	 * Speichert Androiden in die Liste.
	 * Falls ID schon vorhanden, wird statdessen ein Update vorgenommen
	 * 
	 * @param androide
	 */
	public void insert(ANAndroide androide)
	{

		ANAndroide old = map.get(androide.getSeriennummer());
		if (old == null)
		{
			// neuen Androiden einfuegen
			System.out.println("Neuer Androide soll eingefuegt werden:");
			System.out.println("Starte checks fuer Androiden mit ID " + androide.getSeriennummer());
			Integer checkedSeriennummer = androide.getCheckedSeriennummer(androide, androide); // Zwei mal androide, da Haupttyp und Software hier irrelevant sind
			map.put(checkedSeriennummer, androide);
			androide.addToHistory(androide);
		} else {
			// Androide soll update erhalten
			System.out.println("Androide mit ID " + androide.getSeriennummer() + " soll Update erhalten:");
			Integer checkedSeriennummer = androide.getCheckedSeriennummer(androide, old);
			map.put(checkedSeriennummer, androide);
			map.get(checkedSeriennummer).copyHistory(old);
		}

	}

	/**
	 * Findet einen Androiden mit einer bestimmten ID und gibt dessen Beschreibung zurueck
	 * 
	 * @param ID
	 * @return Beschreibung des Androiden
	 */
	public String find(int ID)
	{
		ANAndroide a = map.get(ID);
		if (a == null)
			return new String("Androide mit ID '" + ID + "' nicht vorhanden.");
		return a.toString();
	}

	/**
	 * Gibt die Aenderungen eines Androiden zurueck
	 * 
	 * @param ID
	 */
	public void printHistory(int ID)
	{
		ANAndroide a = map.get(ID);
		if (a != null)
			a.printHistory();
	}

	/**
	 * Gibt die Anzahl der Androiden aus
	 */
	public void size()
	{
		System.out.println(map.size() - 1); //-1 wegen null-entry im Konstruktor
	}

	/**
	 * Gibt einen Iterator fuer alle Androiden aus
	 * 
	 * @return der Iterator
	 */
	public Iterator<ANAndroide> iterator()
	{
		return map.values().iterator();
	}

}
