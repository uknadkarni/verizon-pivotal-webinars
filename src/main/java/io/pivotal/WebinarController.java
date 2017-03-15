package io.pivotal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebinarController {

	public WebinarController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showForm(Model model) {
		return "form";
	}

}
