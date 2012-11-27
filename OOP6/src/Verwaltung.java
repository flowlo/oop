import java.util.HashMap;

/**
 * Die Liste aus der Angabe (zur Speicherung der Androiden)
 * @author Simon
 *
 */
public class Verwaltung {
	
	private HashMap<Integer,ANAndroide> map;
	

	public Verwaltung()
	{
		map=new HashMap<Integer,ANAndroide>();
		//null ist standardmaessig drinnen... muss bei jeder Ausgabe weggenommen werden.
		map.put(null, null);
	}
	
	
	/**
	 * Speichert Androiden in die Liste.
	 * Falls ID schon vorhanden, wird statdessen ein Update vorgenommen
	 * @param a
	 */
	public void insert(ANAndroide a)
	{
		System.out.println("Starte checks fuer Androiden mit ID "+a.getID());
		a.checkSkin();
		
		
		map.put(a.getID(), a);
	}
	
	
	public String find(int ID)
	{
		ANAndroide a=map.get(ID);
		if(a==null) return new String("Androide mit ID '"+ID+"' nicht vorhanden.");
		return a.toString();
	}
	
	public void test()
	{
		System.out.println(map.size()-1); //-1 wegen null-entry im Konstruktor
	}
	
	
}
