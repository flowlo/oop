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

		ANAndroide old = map.get(androide.getID());
		if (old == null)//neuen Androiden einfuegen
		{
			System.out.println("Neuer Androide soll eingefuegt werden:");
			System.out.println("Starte checks fuer Androiden mit ID " + androide.getID());
			androide.checkSkin();
			androide.checkAktorenSet();
			map.put(androide.getID(), androide);
			androide.addToHistory(androide);
		} else {
			//Androide soll update erhalten
			System.out.println("Androide mit ID " + androide.getID() + " soll Update erhalten:");
			androide.checkSkin();
			androide.checkAktorenSet();
			old.checkHauptTyp(androide); //checke ob sich der Haupttyp aendert
			androide.checkSoftware();
			androide.checkSoftwareSecurityLevel(old.getSecurityLevel()); // checke, ob dich das Sicherheitslevel der Software aendert
			map.put(androide.getID(), androide);
			map.get(androide.getID()).copyHistory(old);
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
