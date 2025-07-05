package io.pivotal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring MVC Controller for handling web requests related to the Verizon Pivotal Webinars application.
 *
 * <p>This controller is responsible for serving the main webinar catalog page. It handles HTTP requests
 * and returns appropriate view names for rendering by the Thymeleaf template engine.</p>
 *
 * <p>The controller currently provides a single endpoint that displays a static catalog of webinars
 * with the following information for each webinar:</p>
 * <ul>
 *   <li>Date of the webinar</li>
 *   <li>Topic/Title with links to recordings</li>
 *   <li>Detailed description of the content</li>
 *   <li>Presenter information with links to profiles</li>
 * </ul>
 *
 * <p>All webinar data is currently embedded in the HTML template (form.html) rather than being
 * dynamically loaded from a database or external service.</p>
 *
 * @author Pivotal
 * @version 0.0.1-SNAPSHOT
 * @since 1.0
 * @see org.springframework.stereotype.Controller
 * @see org.springframework.web.bind.annotation.RequestMapping
 */
@Controller
public class WebinarController {

	/**
	 * Default constructor for the WebinarController.
	 *
	 * <p>This constructor is automatically called by Spring's dependency injection container
	 * when creating an instance of this controller. No special initialization is required
	 * as this controller serves static content.</p>
	 */
	public WebinarController() {
		// Default constructor - no special initialization required
	}

	/**
	 * Handles GET requests to the root path ("/") and displays the main webinar catalog page.
	 *
	 * <p>This method serves as the main entry point for the application. When users access
	 * the root URL, they will be presented with a formatted table containing information
	 * about all available Pivotal webinars for Verizon.</p>
	 *
	 * <p>The method returns the view name "form" which corresponds to the Thymeleaf template
	 * located at src/main/resources/templates/form.html. This template contains:</p>
	 * <ul>
	 *   <li>Verizon and Pivotal branding/logos</li>
	 *   <li>A structured table of webinar information</li>
	 *   <li>Links to webinar recordings and presenter profiles</li>
	 *   <li>Styling and layout elements</li>
	 * </ul>
	 *
	 * @param model the Spring MVC Model object for passing data to the view (currently unused
	 *              as all data is static in the template)
	 * @return the view name "form" which resolves to the form.html template
	 *
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.ui.Model
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showForm(Model model) {
		return "form";
	}

}
