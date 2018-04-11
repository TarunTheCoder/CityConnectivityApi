package com.mc.travel.road.model.route;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tarundeep Singh
 * This class encapsulates state and behavior of a directory of Routes.
 */
public class RouteDirectory {

	private final Set<Route> allRoutes = new HashSet<>();

	public void add(Route route) {
		if (route == null) {
			throw new IllegalArgumentException("Null Routes Are Not Allowed In Directory.");
		}
		
		Set<Route> routeToBeRemovedInCaseOfRouteMerger = new HashSet<>();
		for (Route aRouteInTheDirectory : allRoutes) {
			if (aRouteInTheDirectory.doesThisRouteHasACityCommonToTheCitiesInGivenRoute(route)) {
				aRouteInTheDirectory.mergeThisRouteToTheGivenRoute(route);
				routeToBeRemovedInCaseOfRouteMerger.add(aRouteInTheDirectory);
			}
		}

		allRoutes.removeAll(routeToBeRemovedInCaseOfRouteMerger);
		allRoutes.add(route);
	}

	public boolean contains(Route route) {
		return allRoutes.contains(route);
	}

	public String containsARouteWhichConnectsGivenCities(String cityName1, String cityName2) {

		String citiesConnected = "no";

		for (Route route : allRoutes) {
			if (route.contains(cityName1)) {
				if (route.contains(cityName2)) {
					citiesConnected = "yes";
				}
				break;
			}
		}
		return citiesConnected;
	}

	public String toString() {
		return allRoutes.toString();
	}

}
