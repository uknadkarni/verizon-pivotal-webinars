# Verizon Pivotal Webinars - Complete Documentation

## Table of Contents

1. [Project Overview](#project-overview)
2. [Quick Start](#quick-start)
3. [Architecture](#architecture)
4. [Development Guide](#development-guide)
5. [Configuration](#configuration)
6. [Deployment](#deployment)
7. [API Reference](#api-reference)
8. [Testing](#testing)
9. [Security](#security)
10. [Troubleshooting](#troubleshooting)
11. [Project History](#project-history)

---

## Project Overview

### Executive Summary

The Verizon Pivotal Webinars application is a Spring Boot web application that serves as a centralized catalog of Pivotal's Cloud Native webinars specifically created for Verizon. This application demonstrates the collaboration between Verizon and Pivotal in delivering cloud-native education and technology transfer.

### Business Context

**Partnership Background**: Developed as part of the strategic partnership between Verizon and Pivotal to educate Verizon teams on cloud-native technologies and demonstrate Pivotal's platform capabilities.

**Business Value**:
- Knowledge Transfer: Centralized access to educational content
- Technology Showcase: Demonstrates Pivotal platform capabilities  
- Partnership Visibility: Highlights Verizon-Pivotal collaboration
- Reference Architecture: Example of cloud-native application design

### Technology Stack

| Component | Technology | Version | Purpose |
|-----------|------------|---------|---------|
| Framework | Spring Boot | 1.4.1 | Application framework |
| Web | Spring MVC | 4.3.x | Web layer |
| Template Engine | Thymeleaf | 2.1.x | Server-side templating |
| Web Server | Embedded Tomcat | 8.5.x | HTTP server |
| Build Tool | Maven | 3.x | Dependency management |
| Platform | Cloud Foundry | N/A | Deployment platform |
| Monitoring | Spring Boot Actuator | 1.4.x | Health checks |

### Webinar Content

The application displays 6 webinars from March-May 2017:

1. **Dingo Postgres Tile** (03/14/2017) - Dr. Nic - Database management solutions
2. **Concourse Demo** (03/23/2017) - Daxter Mateo - CI/CD with Concourse
3. **Pivotal Cloud Cache** (03/28/2017) - Prasad Radhakrishnan - Caching solutions
4. **Apigee Integration with PCF** (03/29/2017) - Prithpal Bhogil - API management
5. **Volume Services with PCF** (04/26/2017) - Kartik Lunkad - Persistent storage
6. **Managing Microservice Deployments** (05/09/2017) - Kenny Bastani & Prithpal Bhogil - Microservices patterns

---

## Quick Start

### Prerequisites

- Java 8 or higher
- Maven 3.x (or use included wrapper)
- Cloud Foundry CLI (for deployment)

### Running Locally

```bash
# Clone repository
git clone <repository-url>
cd verizon-pivotal-webinars

# Run application
./mvnw spring-boot:run

# Access application
open http://localhost:8080
```

### Building and Packaging

```bash
# Build JAR file
./mvnw clean package

# Run JAR directly
java -jar target/verizon-pivotal-webinars-0.0.1-SNAPSHOT.jar
```

### Running Tests

```bash
# Run all tests
./mvnw test

# Run with coverage
./mvnw test jacoco:report
```

---

## Architecture

### High-Level Architecture

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Web Browser   │    │  Spring Boot    │    │  Static Content │
│                 │◄──►│  Application    │◄──►│  (Templates +   │
│ - HTML/CSS/JS   │    │  - Controller   │    │   Resources)    │
└─────────────────┘    │  - Thymeleaf    │    └─────────────────┘
                       │  - Actuator     │
                       └─────────────────┘
```

### Component Structure

**Presentation Layer**:
- `WebinarController.java` - Handles HTTP requests
- `form.html` - Thymeleaf template for webinar catalog
- `view.css` - Stylesheet for UI styling
- Static resources (images, CSS)

**Business Layer**:
- Currently minimal - serves static content
- Future: Business logic for webinar management

**Infrastructure Layer**:
- Embedded Tomcat web server
- Spring Boot Actuator for monitoring
- Cloud Foundry deployment configuration

### Design Patterns

- **MVC Pattern**: Model (static data), View (Thymeleaf), Controller (Spring MVC)
- **Dependency Injection**: Spring IoC container manages beans
- **Auto-Configuration**: Spring Boot configures components automatically

---

## Development Guide

### Project Structure

```
verizon-pivotal-webinars/
├── src/
│   ├── main/
│   │   ├── java/io/pivotal/
│   │   │   ├── FdcPivotalWebinarsApplication.java  # Main application
│   │   │   └── WebinarController.java              # Web controller
│   │   └── resources/
│   │       ├── application.properties              # Configuration
│   │       ├── static/                            # Static assets
│   │       │   ├── css/view.css                   # Stylesheet
│   │       │   └── images/                        # Images
│   │       └── templates/
│   │           └── form.html                      # Main template
│   └── test/
│       └── java/io/pivotal/
│           └── FdcPivotalWebinarsApplicationTests.java
├── DOCUMENTATION.md                               # This file
├── README.md                                      # Quick overview
├── CHANGELOG.md                                   # Project history
├── manifest.yml                                   # CF deployment
└── pom.xml                                        # Maven config
```

### Development Environment Setup

**IDE Setup**:
1. Import as Maven project
2. Ensure JDK 8+ is configured
3. Enable auto-import for Maven dependencies

**Running in Development**:
```bash
# With hot reload
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.devtools.restart.enabled=true"

# Debug mode
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

### Coding Standards

**Java Code Style**:
- Classes: PascalCase (`WebinarController`)
- Methods: camelCase (`showForm`)
- Variables: camelCase (`model`)
- Constants: UPPER_SNAKE_CASE

**Documentation Requirements**:
- All public classes and methods must have JavaDoc
- Include `@param`, `@return`, and `@throws` where applicable
- Provide meaningful descriptions and examples

### Adding New Features

**New Endpoint Example**:
```java
@RequestMapping(value = "/api/webinars", method = RequestMethod.GET)
@ResponseBody
public List<Webinar> getWebinars() {
    // Implementation
}
```

**Static Resources**: Place in `src/main/resources/static/`
**Templates**: Place in `src/main/resources/templates/`

---

## Configuration

### Application Properties

The main configuration file is `src/main/resources/application.properties`. Currently uses Spring Boot defaults.

**Common Configuration Examples**:
```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/

# Logging Configuration
logging.level.io.pivotal=INFO
logging.level.org.springframework=WARN
logging.file.name=logs/application.log

# Thymeleaf Configuration
spring.thymeleaf.cache=true
spring.thymeleaf.mode=HTML
spring.thymeleaf.encoding=UTF-8

# Actuator Configuration
management.endpoints.web.exposure.include=health,info
management.endpoint.health.show-details=never
```

### Environment-Specific Configuration

**Development** (`application-dev.properties`):
```properties
server.port=8080
logging.level.io.pivotal=DEBUG
spring.thymeleaf.cache=false
spring.devtools.restart.enabled=true
management.endpoints.web.exposure.include=*
```

**Production** (`application-prod.properties`):
```properties
logging.level.io.pivotal=WARN
spring.thymeleaf.cache=true
server.error.include-stacktrace=never
management.endpoints.web.exposure.include=health,info
server.tomcat.max-threads=200
```

### Environment Variables

Override properties using environment variables:
```bash
export SERVER_PORT=9090
export SPRING_PROFILES_ACTIVE=prod
export LOGGING_LEVEL_IO_PIVOTAL=DEBUG
```

---

## Deployment

### Local Deployment

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Using JAR file
./mvnw clean package
java -jar target/verizon-pivotal-webinars-0.0.1-SNAPSHOT.jar
```

### Cloud Foundry Deployment

**Prerequisites**:
```bash
# Install CF CLI
brew install cloudfoundry/tap/cf-cli  # macOS
# or download from https://github.com/cloudfoundry/cli/releases

# Login to Cloud Foundry
cf login -a <api-endpoint>
```

**Deployment Steps**:
```bash
# Build application
./mvnw clean package

# Deploy using manifest
cf push

# Verify deployment
cf apps
cf logs verizon-pivotal-webinars --recent
```

**Manifest Configuration** (`manifest.yml`):
```yaml
applications:
- name: verizon-pivotal-webinars
  memory: 1024M
  host: verizon-pivotal-webinars
  path: target/verizon-pivotal-webinars-0.0.1-SNAPSHOT.jar
  buildpack: https://github.com/cloudfoundry/java-buildpack
```

### Docker Deployment

**Dockerfile**:
```dockerfile
FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/verizon-pivotal-webinars-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
```

**Build and Run**:
```bash
./mvnw clean package
docker build -t verizon-pivotal-webinars .
docker run -p 8080:8080 verizon-pivotal-webinars
```

### Scaling

**Cloud Foundry Scaling**:
```bash
# Scale instances
cf scale verizon-pivotal-webinars -i 3

# Scale memory
cf scale verizon-pivotal-webinars -m 2G
```

---

## API Reference

### Endpoints

#### GET /

**Description**: Main webinar catalog page

**Method**: `GET`

**URL**: `/`

**Parameters**: None

**Response**: HTML page containing the webinar catalog

**Status Codes**:
- `200 OK` - Successfully retrieved the page
- `500 Internal Server Error` - Server error

**Example**:
```bash
curl -X GET http://localhost:8080/
```

#### GET /actuator/health

**Description**: Application health status

**Response**:
```json
{
  "status": "UP"
}
```

### Response Format

The main page returns HTML with:
- **Header**: Verizon and Pivotal logos, page title
- **Content**: Webinar table with dates, topics, descriptions, presenters
- **Footer**: Deployment information

### Static Resources

- **CSS**: `/css/view.css`
- **Images**: `/images/*` (logos, borders)
- **JavaScript**: `/js/*` (if any)

---

## Testing

### Current Tests

**Integration Test**: `FdcPivotalWebinarsApplicationTests.java`
- Tests Spring application context loads successfully
- Verifies all beans are created and wired correctly
- Ensures no configuration errors exist

### Running Tests

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=FdcPivotalWebinarsApplicationTests

# Run with coverage report
./mvnw test jacoco:report

# Skip tests during build
./mvnw package -DskipTests
```

### Manual Testing Checklist

**Functional Testing**:
- [ ] Application starts successfully on port 8080
- [ ] Main page loads without errors
- [ ] All images display correctly (logos, borders)
- [ ] CSS styling applies correctly
- [ ] All webinar links are functional
- [ ] Table displays all 6 webinar entries

**Browser Compatibility**:
- [ ] Chrome (latest version)
- [ ] Firefox (latest version)
- [ ] Safari (latest version)
- [ ] Edge (latest version)

**Performance Testing**:
- [ ] Page loads within 2 seconds
- [ ] No console errors in browser
- [ ] Memory usage remains stable

### Recommended Test Additions

**Controller Unit Tests**:
```java
@Test
public void shouldReturnFormViewName() {
    Model model = new ExtendedModelMap();
    WebinarController controller = new WebinarController();
    String viewName = controller.showForm(model);
    assertEquals("form", viewName);
}
```

**Web Layer Integration Tests**:
```java
@WebMvcTest(WebinarController.class)
public class WebinarControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnWebinarCatalogPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"));
    }
}
```

---

## Security

### Current Security Status

**Security Assessment**:
- **Authentication**: None (public content)
- **Authorization**: None required
- **Data Encryption**: HTTP only (no HTTPS)
- **Input Validation**: Minimal (no user input)
- **Session Management**: Default Spring Boot
- **Error Handling**: Default error pages

### Security Considerations

**Current Strengths**:
- Stateless application design
- No user input processing
- Static content only
- No sensitive data storage
- Simple attack surface

**Areas for Improvement**:
- HTTPS/TLS implementation
- Security headers configuration
- Actuator endpoint security
- Dependency vulnerability scanning

### Recommended Security Enhancements

**HTTPS Configuration**:
```properties
# SSL Configuration
server.ssl.enabled=true
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=${SSL_KEYSTORE_PASSWORD}
server.ssl.key-store-type=PKCS12
```

**Security Headers**:
```properties
# Security Headers
security.headers.frame-options=DENY
security.headers.content-type-options=nosniff
security.headers.xss-protection=1; mode=block
```

**Actuator Security**:
```properties
# Secure actuator endpoints
management.endpoints.web.exposure.include=health,info
management.endpoint.health.show-details=never
```

### Vulnerability Management

**Dependency Scanning**:
```bash
# OWASP Dependency Check
./mvnw org.owasp:dependency-check-maven:check

# Snyk vulnerability scanning
snyk test
```

---

## Troubleshooting

### Common Issues

#### Application Won't Start

**Problem**: Port 8080 already in use
```
Error: Port 8080 was already in use
```

**Solutions**:
```bash
# Find process using port 8080
lsof -i :8080

# Kill process
kill -9 <PID>

# Use different port
java -Dserver.port=8081 -jar app.jar
```

**Problem**: Java version mismatch
```
Error: Unsupported major.minor version
```

**Solutions**:
```bash
# Check Java version
java -version

# Set correct JAVA_HOME
export JAVA_HOME=/path/to/java8
```

#### Runtime Issues

**Problem**: 404 Not Found on root path
```
Error: Whitelabel Error Page - 404
```

**Solutions**:
- Verify @RequestMapping annotation on controller
- Check component scanning includes controller package
- Ensure controller class is properly annotated

**Problem**: Static resources not loading
```
Error: GET /css/view.css 404
```

**Solutions**:
```properties
# Verify static resource configuration
spring.web.resources.static-locations=classpath:/static/
```

**Problem**: Template resolution errors
```
Error: Template 'form' not found
```

**Solutions**:
```properties
# Verify Thymeleaf configuration
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

#### Cloud Foundry Issues

**Problem**: Push fails with buildpack error
```
Error: Failed to compile droplet
```

**Solutions**:
```bash
# Check buildpack logs
cf logs verizon-pivotal-webinars --recent

# Specify buildpack explicitly in manifest.yml
buildpack: java_buildpack
```

**Problem**: Application crashes after deployment
```
Error: App instance exited with guid... exit_status:1
```

**Solutions**:
```bash
# Check application logs
cf logs verizon-pivotal-webinars --recent

# Verify JAR file is executable
# Check memory allocation in manifest.yml
```

### Diagnostic Commands

**Application Diagnostics**:
```bash
# Check Java processes
jps -v

# Monitor JVM metrics
jstat -gc <PID> 5s

# Application health
curl http://localhost:8080/actuator/health
```

**Network Diagnostics**:
```bash
# Check port connectivity
telnet localhost 8080

# HTTP response analysis
curl -v http://localhost:8080/
```

### Getting Help

**When reporting issues, include**:
1. Full startup and error logs
2. Java version and OS information
3. Relevant application.properties
4. Steps to reproduce the issue
5. Expected vs actual behavior

**Support Resources**:
- Spring Boot Documentation: https://docs.spring.io/spring-boot/docs/current/reference/html/
- Cloud Foundry Documentation: https://docs.cloudfoundry.org/
- Stack Overflow: Tag questions with `spring-boot`, `cloud-foundry`

---

## Project History

### Version History

**v0.0.1-SNAPSHOT (2017)**:
- Initial Spring Boot application implementation
- Basic web controller for serving webinar catalog
- Thymeleaf template for displaying webinar information
- Static resources (CSS, images) for UI styling
- Cloud Foundry deployment configuration
- Maven build configuration
- Basic integration tests

### Webinar Content History

**March 2017**:
- Dingo Postgres Tile (Dr. Nic) - March 14
- Concourse Demo (Daxter Mateo) - March 23
- Pivotal Cloud Cache (Prasad Radhakrishnan) - March 28
- Apigee Integration with PCF (Prithpal Bhogil) - March 29

**April-May 2017**:
- Volume Services with PCF (Kartik Lunkad) - April 26
- Managing Microservice Deployments (Kenny Bastani & Prithpal Bhogil) - May 9

### Technical Evolution

**Original Implementation**:
- Spring Boot 1.4.1 with Java 8
- Simple MVC architecture
- Static content embedded in HTML template
- Cloud Foundry deployment ready

**Documentation Enhancement (Current)**:
- Comprehensive JavaDoc comments added
- HTML template documentation
- CSS styling documentation
- Configuration file documentation
- Complete project documentation

### Future Roadmap

**Short-term Enhancements**:
- [ ] Security improvements (HTTPS, headers)
- [ ] Comprehensive testing implementation
- [ ] Performance optimization
- [ ] Dependency updates

**Medium-term Features**:
- [ ] Database integration for dynamic content
- [ ] User authentication system
- [ ] Content management interface
- [ ] RESTful API development

**Long-term Vision**:
- [ ] Microservices architecture migration
- [ ] Advanced analytics and reporting
- [ ] Mobile application development
- [ ] Integration with learning management systems

### Lessons Learned

**Technical Insights**:
- Spring Boot provides excellent rapid development capabilities
- Thymeleaf offers good server-side templating for simple applications
- Cloud Foundry simplifies deployment and scaling
- Static content approach works well for catalog-style applications

**Business Value**:
- Centralized webinar catalog improves knowledge accessibility
- Partnership branding enhances collaboration visibility
- Simple architecture enables quick deployment and maintenance
- Reference implementation demonstrates cloud-native patterns

---

## Conclusion

The Verizon Pivotal Webinars application successfully serves its purpose as a webinar catalog and partnership demonstration. While currently simple in scope, it provides a solid foundation for future enhancements and serves as an excellent example of cloud-native application development using Spring Boot and Cloud Foundry.

The comprehensive documentation ensures that the application can be maintained, extended, and used as a reference for future projects. The clear architecture and well-documented codebase make it an ideal starting point for teams learning cloud-native development practices.

For questions or support, refer to the troubleshooting section above or consult the relevant technology documentation links provided throughout this guide.
