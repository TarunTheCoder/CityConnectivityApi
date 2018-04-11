/**
 * 
 */
package com.mc.travel.road;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mc.travel.road.model.route.RouteDirectory;


/**
 * @author Tarundeep Singh
 * The controller class for Class Connectivity API
 */
@RestController
public class RouteController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RouteController.class);
	
	private final String NO = "no";
	
	@Autowired
	private RouteDirectory routeDirectory;
	
	@GetMapping("/connected")
	public String checkCityConnectivity(
			@RequestParam(name="origin", required=true) String origin, 
			@RequestParam(name="destination", required=true) String dest) {
		
		if(invalid(origin) || invalid(dest)) {
			LOG.error("Invalid Origin or Destination City.");
			return NO;
		}
		return this.routeDirectory.containsARouteWhichConnectsGivenCities(origin, dest);
	}

	private boolean invalid(String city) {
		return city.trim().isEmpty();
	}

}
