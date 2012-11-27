import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Die Liste aus der Angabe (zur Speicherung der Androiden)
 * 
 * @author Simon
 * 
 */
public class Verwaltung {

	private LinkedHashMap<Integer, ANAndroide> map;

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
	 * @param a
	 */
	public void insert(ANAndroide a)
	{

		ANAndroide old = map.get(a.getID());
		if (old == null)//neuen Androiden einfuegen
		{
			System.out.println("Neuer Androide soll eingefuegt werden:");
			System.out.println("Starte checks fuer Androiden mit ID " + a.getID());
			a.checkSkin();
			a.checkAktorenSet();
			map.put(a.getID(), a);
			a.addToHistory(a);
		} else {
			//Androide soll update erhalten
			System.out.println("Androide mit ID " + a.getID() + " soll Update erhalten:");
			a.checkSkin();
			a.checkAktorenSet();
			old.checkHauptTyp(a); //checke ob sich der Haupttyp aendert
			a.checkSoftware();
			a.checkSoftwareSecurityLevel(old.getSecurityLevel()); // checke, ob dich das Sicherheitslevel der Software aendert
			map.put(a.getID(), a);
			map.get(a.getID()).copyHistory(old);
		}

	}

	public String find(int ID)
	{
		ANAndroide a = map.get(ID);
		if (a == null)
			return new String("Androide mit ID '" + ID + "' nicht vorhanden.");
		return a.toString();
	}

	public void printHistory(int ID)
	{
		ANAndroide a = map.get(ID);
		if (a != null)
			a.printHistory();
	}

	public void test()
	{
		System.out.println(map.size() - 1); //-1 wegen null-entry im Konstruktor
	}

	public Iterator<ANAndroide> iterator()
	{
		return map.values().iterator();
	}

}
