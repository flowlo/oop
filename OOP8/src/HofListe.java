/*
 * Collection fuer Bauernhoefe.
 * Zusicherung: 
 * - jeder Bauernhof hat einen eindeutigen Namen
 * - jeder Traktor hat eine eindeutige ID
 * - auf Hoefe und Traktoren wird mit deren Namen bzw. Nummern zugegriffen
 * 
 */
@Authors("Simon")
public class HofListe {
	private Bauernhof hof;
	private HofListe next;

	@Authors("Simon")
	public HofListe() {
	}

	@Authors("Simon")
	public boolean addTraktor(String hofname, Traktor traktor) {
		if (hof == null)
			return false; // es gibt keinen Hof in der Liste
		else if (containsTraktor(traktor.getNummer()) != null)
			return false; // Traktor bereits in einem Hof
		else {
			Bauernhof tmp = getBauernhof(hofname);
			if (tmp == null)
				return false; // diesen Hof gibt es nicht
			else {
				tmp.addTraktor(traktor);
				return true;
			}
		}
	}

	@Authors("Simon")
	public boolean removeTraktor(String name, int nummer) {
		Bauernhof tmp = containsTraktor(nummer);
		if (tmp != null) {
			if (tmp.getName().equals(name)) {
				tmp.removeTraktor(nummer);
				return true;
			} else
				return false; // Traktor nicht bei diesem Hof
		} else
			return false; // Traktor in keinem Hof
	}

	@Authors("Simon")
	public void erhoeheBiogasVerbrauch(int nummer, Float biogas) {
		Bauernhof tmp = containsTraktor(nummer);
		if (tmp != null)
			tmp.erhoeheBiogasVerbrauch(nummer, biogas);
	}

	@Authors("Simon")
	public void erhoeheDieselVerbrauch(int nummer, Integer diesel) {
		Bauernhof tmp = containsTraktor(nummer);
		if (tmp != null)
			tmp.erhoeheDieselVerbrauch(nummer, diesel);
	}

	@Authors("Simon")
	public double getDurchschnittFassungskapazitaet(String name,
			TraktorGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getDurchschnittFassungskapazitaet(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	public int getMaximumSaescharen(String name, TraktorGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getMaximumSaescharen(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	public int getMinimumSaescharen(String name, TraktorGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getMinimumSaescharen(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	public double getDurchschnittDieselverbrauch(String name,
			EinsatzzweckGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getDurchschnittDieselverbrauch(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	public double getDurchschnittBiogasverbrauch(String name,
			EinsatzzweckGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getDurchschnittBiogasverbrauch(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	public double getDurchschnittBetriebsstunden(String name,
			EinsatzzweckGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getDurchschnittBetriebsstunden(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	public double getDurchschnittBetriebsstunden(String name,
			TraktorGruppierung gruppierung) {
		Bauernhof tmp = getBauernhof(name);
		if (tmp != null)
			return tmp.getDurchschnittBetriebsstunden(gruppierung);
		else
			return -1;
	}

	@Authors("Simon")
	private Bauernhof containsTraktor(int nummer) {
		if (hof == null)
			return null;
		else if (hof.containsTraktor(nummer))
			return hof;
		else if (next == null)
			return null;
		else
			return next.containsTraktor(nummer);
	}

	@Authors("Simon")
	public void addBauernhof(Bauernhof hof) {
		if (this.hof == null)
			this.hof = hof;
		else if (this.hof.getName().equals(hof.getName()))
			this.hof = hof;
		else {
			if (next == null)
				next = new HofListe();
			next.addBauernhof(hof);
		}
	}

	@Authors("Simon")
	public String getAlleNamen() {
		return buildAlleNamen(new StringBuilder());
	}

	@Authors("Simon")
	private String buildAlleNamen(StringBuilder sb) {
		if (hof != null) {
			sb.append(hof.getName());
			sb.append("\n");
			if (next != null)
				next.buildAlleNamen(sb);
			return sb.toString();
		} else
			return sb.toString();
	}

	@Authors("Simon")
	private Bauernhof getBauernhof(String name) {
		if (hof == null)
			return null;
		else if (hof.getName().equals(name))
			return hof;
		else {
			if (next == null)
				return null;
			return next.getBauernhof(name);
		}
	}

	@Authors("Simon")
	public void erhoeheBetriebsStunden(int id, int stunden) {
		Bauernhof tmp = containsTraktor(id);
		if (tmp == null)
			return;
		else {
			tmp.getTraktor(id).erhoeheBetriebsstunden(stunden);
		}
	}

	@Authors("Simon")
	public int getBetriebsStunden(int id) {
		Bauernhof tmp = containsTraktor(id);
		if (tmp == null)
			return -1;
		else {
			return tmp.getTraktor(id).getBetriebsstunden();
		}
	}

}
