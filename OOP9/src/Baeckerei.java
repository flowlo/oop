import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Repraesentiert eine Baeckerei
 * 
 * @author Dominik
 * @author Simon
 * 
 */
public class Baeckerei {
	private HashMap<Form, KeksBackmaschine> maschinen;
	private DoppelkeksBackmaschine doppelKeksMaschine;

	public Baeckerei()
	{
		this.doppelKeksMaschine = new DoppelkeksBackmaschine();
		maschinen = new HashMap<Form, KeksBackmaschine>();
	}

	public void addMaschine(Form form)
	{
		this.maschinen.put(form, new KeksBackmaschine(form));
	}

	public Keksdose produziere(Bestellung bestellung) throws BackmaschineNichtVorhandenException
	{
		Keksdose dose = new Keksdose();
		List<Position> liste = bestellung.getPositionen();
		for (Position position : liste)
		{
			if (position.getFuellung() == null)
			{
				dose.addKekse(backePosition(position));
			}
			else
			{
				List<Keks> blech = backePosition(position);
				for (Keks k : blech)
				{
					doppelKeksMaschine.lade(k);
					try {
						dose.addKeks(doppelKeksMaschine.backe(position.getFuellung()));
					} catch (BackmaschineNichtBeladenException e) {
						//kann nicht vorkommen
						System.out.println("wtf");
					}
				}
			}
		}
		return dose;
	}

	private List<Keks> backePosition(Position position) throws BackmaschineNichtVorhandenException
	{
		List<Keks> blech = new ArrayList<Keks>();
		KeksBackmaschine maschine = maschinen.get(position.getForm());
		if (maschine == null)
			throw new BackmaschineNichtVorhandenException("Maschine fuer Form " + position.getForm() + " nicht vorhanden!");
		for (int x = 0; x < position.getAnzahl(); x++)
		{
			blech.add(maschine.backe(position.getTeigart()));
		}
		return blech;
	}
}
