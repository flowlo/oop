package entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Stellt einen Ort dar, an dem Proben oder Auftritte stattfinden koennen.
 * 
 * @author Lorenz
 */
public class Location {
	private String name, address;
	private List<String> infrastructure;

	/**
	 * Initialisiert einen neuen Ort.
	 * 
	 * @param name
	 *            Der Name des Orts, wie z.B. eines Clubs
	 * @param address
	 *            Physische Adresse des Orts (Strasze und Hausnummer)
	 * @param infrastructure
	 *            Merkmale der Ausstattung des Orts
	 */
	public Location(String name, String address, Collection<String> infrastructure) {
		this.name = name;
		this.address = address;
		this.infrastructure = new LinkedList<String>(infrastructure);
	}

	/**
	 * Initialisiert einen neuen Ort.
	 * 
	 * @param name
	 *            Der Name des Orts, wie z.B. eines Clubs
	 * @param address
	 *            Physische Adresse des Orts (Strasze und Hausnummer)
	 * @param infrastructure
	 *            Merkmale der Ausstattung des Orts
	 */
	public Location(String name, String address, String... infrastructure) {
		this(name, address, Arrays.asList(infrastructure));
	}

	/**
	 * Wird verwendet um festzustellen ob dieser Ort ueber bestimmte Infrastruktur verfuegt.
	 * 
	 * @param infrastructure
	 *            Umschreibung der Infrastruktur, in der Form in der sie initialisiert oder hinzugefuegt wurde.
	 * @return wahr, falls der Ort ueber die Infrastruktur verfuegt, anderfalls falsch.
	 */
	public boolean providesInfrastructure(String infrastructure) {
		return this.infrastructure.contains(infrastructure);
	}

	/**
	 * Vermerkt bestimmte Infrastruktur bei diesem Ort.
	 * 
	 * @param infrastructure
	 *            Umschreibung der vorhandenen Infrastruktur.
	 * @return wahr, wenn die Infrastruktur hinzugefuegt wurde, andernfalls falsch
	 */
	public boolean addInfrastructure(String infrastructure) {
		return this.infrastructure.add(infrastructure);
	}

	/**
	 * Entfernt den Vermerk einer bestimmten Infrastruktur bei diesem Ort.
	 * 
	 * @param infrastructure
	 *            Umschreibung der vorhandenen Infrastruktur.
	 * @return wahr, wenn die Infrastruktur entfernt wurde, andernfalls falsch
	 */
	public boolean removeInfrastructure(String infrastructure) {
		return this.infrastructure.remove(infrastructure);
	}

	/**
	 * Um die Liste der Infrastruktur zu erhalten.
	 * 
	 * @return Eine Liste der an diesem Ort verfuegbaren Infrastruktur.
	 */
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
