/**
 * 
 */
package com.mc.travel.road.model.route;

/**
 * @author Tarundeep Singh
 * This class encapsulates state and behavior of a City.
 */
public final class City {
	
	private final String name;

	public City(String name) {
		super();
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Name of a City '"+name+"'");
		}
		this.name = name.toLowerCase().trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
