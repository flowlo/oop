import java.util.HashMap;

/**
 * Die Liste aus der Angabe (zur Speicherung der Androiden)
 * @author Simon
 *
 */
public class Verwaltung {
	
	private HashMap<Integer,ANAndroide> map=new HashMap<Integer,ANAndroide>();
	
	
	/**
	 * Speichert Androiden in die Liste.
	 * Falls ID schon vorhanden, wird statdessen ein Update vorgenommen
	 * @param a
	 */
	public void insert(ANAndroide a)
	{
		a.checkSkin();
		map.put(a.getID(), a);
	}
	
	
	public String find(int ID)
	{
		ANAndroide a=map.get(ID);
		if(a==null) return new String("Androide mit ID '"+ID+"' nicht vorhanden.");
		return a.toString();
	}
	
	
}
