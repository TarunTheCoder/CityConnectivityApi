#City Connectivity API#
This API informs whether two cities in USA are connected via a series of roads. 

## Tech Stack
1.	Java 8
2.	Maven
3.	SpringBoot v2.0.1.RELEASE


## Getting Started
Simply clone or fork SpringBoot project and import the project into your favorite Java editor. Then simply install with maven and run the project as a SpringBoot app in your editor.
The app exposes an endpoint: *http://localhost:8080/connected?origin=city1&destination=city2*

You can test the endpoint on the **Swagger UI** which is available at 
*http://localhost:8080/swagger-ui.html*

**PS:**
Currently this implementation does not work from Command Prompt using *java -jar CityConnectivityApi-1.0.0.RC1.jar* because it gives following exception

>Caused by: java.nio.file.FileSystemNotFoundException: null

This is actually an open [SpringBoot issue](https://github.com/spring-projects/spring-boot/issues/7161).

#### Location of Route File
The default name for the route file is *Default.txt* located in *src/main/resources.* 
The location of the file can be overridden in two ways:
1.	In application.properties, provide the property *route.file.source.location*. For instance *route.file.source.location=file:///<location>/filename.txt* or,
2.	Provide the VM argument *-Droute.file.source.location= file:///<location>/filename.txt* while starting the application

## Application Design
- Composition Relationship: A directory of routes (class:Singleton RouteDirectory) contains various routes (class:Route) of connected cities (class: City).
- Any two or more routes with common cities were programmatically merged into one route, before inserting it into the directory of routes
- A default data file for routes is provided, which can be overridden at runtime using *route.file.source.location* property

#### Methodologies Used
- TDD
- SOLID Principles
- Dependency Injection Pattern

## Spring Actuator
The API is enabled with Spring Actuator for monitoring and management. This is indicated by the fact that 
*http://localhost:8080/actuator/health* yields **up** json message.
You may have to do additional configuration to get access to additional metrics, details of which are out of scope of this document.


## SpringBoot Devtools
Spring-boot-devtools library has been used to leverage automatic restart feature

##Project Site##
Please run *mvn site* to generate project site *index.html* at location *<your-project-path>/target/site/index.html*
You can open this html file in any browser for more details and analysing project reports.
Following reports are available here:
1. FindBugs Report
2. SureFire Report
3. JaCoCo Code Coverage
4. JaCoCo Aggregate (Please ignore as this is not a multi-module project)

## Running the Tests
Simply run *mvn test*, *mvn install* or *mvn site* to run unit tests as well as integration tests.

## Versioning
I used [SemVer](https://semver.org/) for versioning

## Authors
Tarundeep Singh for MC

## Acknowledgements
These are my mentors and I have learned a lot from them
1. Steve Smith for [SOLID Principles](https://app.pluralsight.com/library/courses/principles-oo-design)
2. Mark Seemann for [Encapsulation Principles](https://app.pluralsight.com/library/courses/encapsulation-solid/table-of-contents)
3. Luke Mueller from Pivotal Labs for TDD principles
4. Developers on StackOverflow, Google et al.








