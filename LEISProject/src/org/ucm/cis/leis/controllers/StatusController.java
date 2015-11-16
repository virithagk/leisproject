package org.ucm.cis.leis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ucm.cis.leis.models.Status;
import org.ucm.cis.leis.service.StatusService;


@Controller
public class StatusController {


	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = "/saveStatus", method = RequestMethod.POST)
	public ModelAndView saveStatus(@ModelAttribute("command") Status status, 
			BindingResult result, HttpServletRequest request) {
		statusService.addStatus(status);
		return new ModelAndView("redirect:/addStatus.html");
	}
	
	@RequestMapping(value = "/addStatus", method = RequestMethod.GET)
	public ModelAndView addStatus(@ModelAttribute("command")  Status status,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("statuses",  statusService.getStatuses());
		return new ModelAndView("addStatus", model);
	}
	
	@RequestMapping(value = "/deleteStatus", method = RequestMethod.GET)
	public ModelAndView deleteStatus(@ModelAttribute("command")  Status status,
			BindingResult result, HttpServletRequest request) {
		statusService.deleteStatus(status.getStatusCode());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("statuses",  statusService.getStatuses());
		return new ModelAndView("addStatus", model);
	}
	
	@RequestMapping(value = "/editStatus", method = RequestMethod.GET)
	public ModelAndView editStatus(@ModelAttribute("command")  Status status,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("status",  statusService.getStatus(status.getStatusCode()));
		model.put("statuses",  statusService.getStatuses());
		return new ModelAndView("addStatus", model);
	}
	
	@RequestMapping(value="/statuses", method = RequestMethod.GET)
	public List<Status> getStatuses() {
		return statusService.getStatuses();
	}
	
	
}
