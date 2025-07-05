# Verizon Pivotal Webinars

A Spring Boot web application that displays a catalog of Pivotal's Cloud Native webinars specifically created for Verizon. This application serves as a central hub for accessing recorded webinar sessions covering various cloud-native technologies and practices.

## Overview

This application provides a simple web interface displaying a table of webinars with the following information:
- Date of the webinar
- Topic/Title with links to recordings
- Detailed description of the content
- Presenter information

The webinars cover topics such as:
- Dingo Postgres Tile
- Concourse CI/CD demonstrations
- Pivotal Cloud Cache
- Apigee Integration with PCF
- Volume Services with PCF
- Microservice deployment patterns

## Technology Stack

- **Framework**: Spring Boot 1.4.1
- **Java Version**: 1.8
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Deployment**: Cloud Foundry (Pivotal Cloud Foundry)

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Actuator
- Spring Boot Starter Thymeleaf
- Spring Boot DevTools (test scope)
- Spring Boot Starter Test (test scope)

## Project Structure

```
src/
├── main/
│   ├── java/io/pivotal/
│   │   ├── FdcPivotalWebinarsApplication.java  # Main Spring Boot application
│   │   └── WebinarController.java              # Web controller handling requests
│   └── resources/
│       ├── application.properties              # Application configuration
│       ├── static/                            # Static web assets
│       │   ├── css/view.css                   # Stylesheet
│       │   └── images/                        # Images (logos, UI elements)
│       └── templates/
│           └── form.html                      # Main HTML template
└── test/
    └── java/io/pivotal/
        └── FdcPivotalWebinarsApplicationTests.java  # Basic test class
```

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.x

### Running the Application

1. **Using Maven Wrapper (Recommended)**:
   ```bash
   ./mvnw spring-boot:run
   ```

2. **Using Maven directly**:
   ```bash
   mvn spring-boot:run
   ```

3. **Running the JAR file**:
   ```bash
   mvn clean package
   java -jar target/verizon-pivotal-webinars-0.0.1-SNAPSHOT.jar
   ```

The application will start on the default port (8080) and can be accessed at:
```
http://localhost:8080
```

### Running Tests

```bash
./mvnw test
```

## Deployment

### Cloud Foundry Deployment

The application includes a `manifest.yml` file configured for Cloud Foundry deployment:

```bash
cf push
```

**Deployment Configuration**:
- Application Name: `verizon-pivotal-webinars`
- Memory: 1024M
- Buildpack: Java Buildpack
- Artifact: `target/verizon-pivotal-webinars-0.0.1-SNAPSHOT.jar`

## Application Features

### Web Interface

The application provides a single-page interface featuring:

- **Branding**: Displays both Verizon and Pivotal logos
- **Webinar Catalog**: A structured table showing:
  - Webinar dates (March-May 2017)
  - Clickable topic titles linking to recordings
  - Detailed descriptions of webinar content
  - Presenter information with links to profiles
- **Footer**: Indicates deployment on Pivotal Cloud Foundry

### Endpoints

- **GET /**: Main page displaying the webinar catalog

## Development

### Project Configuration

- **Group ID**: `io.pivotal`
- **Artifact ID**: `verizon-pivotal-webinars`
- **Version**: `0.0.1-SNAPSHOT`
- **Packaging**: JAR

### Building

```bash
./mvnw clean compile
```

### Packaging

```bash
./mvnw clean package
```

## Architecture

This is a simple Spring Boot web application following the MVC pattern:

- **Model**: Static data embedded in the HTML template
- **View**: Thymeleaf template (`form.html`)
- **Controller**: `WebinarController` handling HTTP requests

The application uses Spring Boot's auto-configuration for:
- Embedded Tomcat server
- Thymeleaf template resolution
- Static resource serving
- Actuator endpoints for monitoring

## Contributing

This appears to be a demonstration/reference application. For modifications:

1. Update webinar data in `src/main/resources/templates/form.html`
2. Modify styling in `src/main/resources/static/css/view.css`
3. Add new endpoints in `WebinarController.java`

## License

This project appears to be a demonstration application for Verizon-Pivotal collaboration.
