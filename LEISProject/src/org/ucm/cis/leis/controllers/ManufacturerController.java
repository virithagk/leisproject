package org.ucm.cis.leis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ucm.cis.leis.models.Login;
import org.ucm.cis.leis.models.Manufacturer;
import org.ucm.cis.leis.service.ManufacturerService;


@Controller
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@RequestMapping(value = "/saveManufacturer", method = RequestMethod.POST)
	public ModelAndView saveManufacturer(@ModelAttribute("command") Manufacturer manufacturer, 
			BindingResult result, HttpServletRequest request) {
		manufacturerService.addManufacturer(manufacturer);
		return new ModelAndView("redirect:/addManufacturer.html");
	}
	
	@RequestMapping(value = "/addManufacturer", method = RequestMethod.GET)
	public ModelAndView addManufacturer(@ModelAttribute("command")  Manufacturer manufacturer,
			BindingResult result, Model model1, HttpServletRequest request) {
	
		Login l = (Login) request.getSession().getAttribute("curLogin");
		
		if(l!=null) {
			
		System.out.println("%%%%%%%%%%%%%%blah blah blah%%%Username ::"+ l.getUserName()+ "  efwesdfsgdfg ");
			
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("manufacturers",  manufacturerService.getManufacturers());
		return new ModelAndView("addManufacturer", model);
	}
	
	@RequestMapping(value = "/deleteManufacturer", method = RequestMethod.GET)
	public ModelAndView deleteManufacturer(@ModelAttribute("command")  Manufacturer manufacturer,
			BindingResult result, HttpServletRequest request) {
		manufacturerService.deleteManufacturer(manufacturer.getManufacturerId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("manufacturers",  manufacturerService.getManufacturers());
		return new ModelAndView("addManufacturer", model);
	}
	
	@RequestMapping(value = "/editManufacturer", method = RequestMethod.GET)
	public ModelAndView editManufacturer(@ModelAttribute("command")  Manufacturer manufacturer,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("manufacturer",  manufacturerService.getManufacturer(manufacturer.getManufacturerId()));
		model.put("manufacturers",  manufacturerService.getManufacturers());
		return new ModelAndView("addManufacturer", model);
	}
	
	@RequestMapping(value="/manufacturers", method = RequestMethod.GET)
	public List<Manufacturer> getManufacturers() {
		return manufacturerService.getManufacturers();
	}
}
