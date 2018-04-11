/**
 * 
 */
package com.mc.travel.road.model.route;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Tarundeep Singh
 * This class encapsulates state and behavior of a Route connecting cities.
 */
public final class Route {
	
	private final Set<City> cities;
	
	public Route(String cityLine) {
		if(cityLine==null || cityLine.split(",").length<2) {
			throw new IllegalArgumentException("Invalid CityLine '" + cityLine + "'");
		}
		this.cities = Arrays.stream(cityLine.split(",")).map(s -> new City(s)).collect(toSet());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
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
		Route other = (Route) obj;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		return true;
	}

	public boolean contains(final City expectedCity) {
		return this.cities.contains(expectedCity);
	}

	public int length() {
		return this.cities.size();
	}

	public boolean contains(final String cityName) {
		City city = new City(cityName);
		return contains(city);
	}

	public boolean doesThisRouteHasACityCommonToTheCitiesInGivenRoute(Route route) {
		for (City city : cities) {
			if(route.contains(city)) {
				return true;
			}
		}
		return false;
	}

	public boolean mergeThisRouteToTheGivenRoute(Route route) {
		for (City city : cities) {
			route.addAGivenCity(city);
		}
		return true;
	}

	public boolean addAGivenCity(City city) {
		return this.cities.add(city);
	}
	
	public String toString() {
		return this.cities.toString();
	}

}
