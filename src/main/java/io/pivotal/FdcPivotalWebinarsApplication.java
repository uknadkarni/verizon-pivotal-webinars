package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for the Verizon Pivotal Webinars application.
 *
 * <p>This application serves as a web portal displaying a catalog of Pivotal's Cloud Native
 * webinars specifically created for Verizon. The application provides a simple web interface
 * that displays webinar information including dates, topics, descriptions, and presenter details.</p>
 *
 * <p>The application is built using Spring Boot 1.4.1 and includes the following key features:</p>
 * <ul>
 *   <li>Web interface using Thymeleaf templates</li>
 *   <li>Static resource serving for CSS and images</li>
 *   <li>Spring Boot Actuator for monitoring</li>
 *   <li>Cloud Foundry deployment configuration</li>
 * </ul>
 *
 * <p>The webinars cover various cloud-native technologies and practices including:</p>
 * <ul>
 *   <li>Dingo Postgres Tile</li>
 *   <li>Concourse CI/CD</li>
 *   <li>Pivotal Cloud Cache</li>
 *   <li>Apigee Integration with PCF</li>
 *   <li>Volume Services with PCF</li>
 *   <li>Microservice deployment patterns</li>
 * </ul>
 *
 * @author Pivotal
 * @version 0.0.1-SNAPSHOT
 * @since 1.0
 */
@SpringBootApplication
public class FdcPivotalWebinarsApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * <p>This method bootstraps the Spring Boot application using the default configuration.
	 * The application will start an embedded Tomcat server on port 8080 (default) and
	 * serve the webinar catalog interface.</p>
	 *
	 * <p>The application can be accessed at: http://localhost:8080</p>
	 *
	 * @param args command line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(FdcPivotalWebinarsApplication.class, args);
	}
}
