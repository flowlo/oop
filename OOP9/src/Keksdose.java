import java.util.ArrayList;
import java.util.List;

/**
 * Eine Keksdose enthaelt eine Menge von Keksen.
 * 
 * @author Dominik
 * 
 */
public class Keksdose {
	private List<KeksBasis> kekse;

	public Keksdose()
	{
		kekse=new ArrayList<KeksBasis>();
	}
	
	public Keksdose(List<KeksBasis> kekse) {
		super();
		this.kekse = kekse;
	}

	/**
	 * Schreibt eine Zusammenfassung der aktuellen Keksdose in die Standardausgabe.
	 */
	public void inhalt() {
		for(KeksBasis k : kekse)
		{
			System.out.println(k.toString());
		}
	}
	
	public void addKekse(List<? extends KeksBasis> k)
	{
		kekse.addAll(k);
	}
	
	public void addKeks(KeksBasis k)
	{
		kekse.add(k);
	}

}
