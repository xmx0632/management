package org.xmx0632.management.web.admin;

import java.util.List;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xmx0632.management.service.ApiStatService;

@Controller
@RequestMapping(value = "/admin/apiMonitor")
public class ApiMonitorController {

	private static Logger log = LoggerFactory
			.getLogger(ApiMonitorController.class);

	@Autowired
	private ResourceBundleMessageSource messageSource;

	@Autowired
	private ApiStatService apiStatService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ServletRequest request) {

		List<ApiStat> stats = apiStatService.getStatList();
		model.addAttribute("stats", stats);

		return "admin/apiMonitorList";
	}

	@RequestMapping(value = "reset", method = RequestMethod.GET)
	public String reset(Model model, ServletRequest request) {
		apiStatService.reset();
		return "redirect:/admin/apiMonitor";
	}

}
