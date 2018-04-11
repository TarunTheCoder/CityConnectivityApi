package com.mc.travel.road.load.routes;

import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Tarundeep Singh
 * This class is responsible for reading data from a given Resource.
 */
@Component
public class ReadDataFromFile {

	public Set<String> loadDataFromResourceLineByLine(Resource resource) throws IOException {
		Set<String> setOfStrings = null;
		Stream<String> stream = Files.lines(Paths.get(resource.getURI()));
		if (stream != null) {
			setOfStrings = stream.collect(toSet());
			stream.close();
		}
		return setOfStrings;
	}

}
