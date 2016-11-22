package entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lorenz
 */
public class Location {
	private String name, address;
	private List<String> infrastructure;

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Alle Werte wurden uebernommen 
	 */
	public Location(String name, String address, Collection<String> infrastructure) {
		this.name = name;
		this.address = address;
		this.infrastructure = new LinkedList<String>(infrastructure);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Alle Werte wurden uebernommen
	 * SCHLECHT: You ain't gonna need it! Der Konstruktor wird nie gebraucht. Besser: Ein Konstruktor mit zwei Parametern
	 */
	public Location(String name, String address, String... infrastructure) {
		this(name, address, Arrays.asList(infrastructure));
	}

	public boolean providesInfrastructure(String infrastructure) {
		return this.infrastructure.contains(infrastructure);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Intrastruktur ist gespeichert und kann hinzugefuegt werden
	 */
	public boolean addInfrastructure(String infrastructure) {
		return this.infrastructure.add(infrastructure);
	}

	/*
	 * Vorbedingung: Keine
	 * Nachbedingung: Infrastruktur ist nicht mehr vorhanden
	 * FEHLER: Wenn zwei mal die Infrastruktur 'Sessel' hinzugefuegt wird, ist nicht klar, welche geloescht werden soll, wenn 'Sessel' uebergeben wird.
	 */
	public boolean removeInfrastructure(String infrastructure) {
		return this.infrastructure.remove(infrastructure);
	}

	public List<String> getInfrastructure() {
		return this.infrastructure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((infrastructure == null) ? 0 : infrastructure.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Location other = (Location) obj;

		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}

		if (infrastructure == null) {
			if (other.infrastructure != null) {
				return false;
			}
		} else if (!infrastructure.equals(other.infrastructure)) {
			return false;
		}

		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		return true;
	}
}
