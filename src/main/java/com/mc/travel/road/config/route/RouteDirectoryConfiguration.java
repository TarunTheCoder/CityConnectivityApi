/**
 * 
 */
package com.mc.travel.road.config.route;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.mc.travel.road.load.routes.ReadDataFromFile;
import com.mc.travel.road.model.route.Route;
import com.mc.travel.road.model.route.RouteDirectory;

/**
 * @author Tarundeep Singh
 * This class is responsible for configuring the RouteDirectory object from a given Resource
 *
 */
@Configuration
public class RouteDirectoryConfiguration {
	
	@Autowired
	private ReadDataFromFile readDataFromFile;
	
	@Value("${route.file.source.location:classpath:Default.txt}")
	private Resource resource;

	@Bean
	public RouteDirectory createRouteDirectoryFromResource() throws IOException {
		Set<String> sourceData = readDataFromFile.loadDataFromResourceLineByLine(resource);
		RouteDirectory routeDirectory = new RouteDirectory();
		for (String line : sourceData) {
			Route route = new Route(line);
			routeDirectory.add(route);
		}
		return routeDirectory; 
	}
	
}
