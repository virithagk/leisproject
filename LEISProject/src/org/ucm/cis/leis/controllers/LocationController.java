package org.ucm.cis.leis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.ucm.cis.leis.models.Location;
import org.ucm.cis.leis.service.LocationService;


@Controller
public class LocationController {


	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
	public ModelAndView saveLocation(@ModelAttribute("command") Location location, 
			BindingResult result) {
		locationService.addLocation(location);
		return new ModelAndView("redirect:/addLocation.html");
	}
	
	@RequestMapping(value = "/addLocation", method = RequestMethod.GET)
	public ModelAndView addLocation(@ModelAttribute("command")  Location location,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("locations",  locationService.getLocations());
		return new ModelAndView("addLocation", model);
	}
	
	@RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
	public ModelAndView deleteLocation(@ModelAttribute("command")  Location location,
			BindingResult result) {
		locationService.deleteLocation(location.getRoomId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("locations",  locationService.getLocations());
		return new ModelAndView("addLocation", model);
	}
	
	@RequestMapping(value = "/editLocation", method = RequestMethod.GET)
	public ModelAndView editLocation(@ModelAttribute("command")  Location location,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("location",  locationService.getLocation(location.getRoomId()));
		model.put("locations",  locationService.getLocations());
		return new ModelAndView("addLocation", model);
	}
	
	@RequestMapping(value="/locations", method = RequestMethod.GET)
	public List<Location> getLocations() {
		return locationService.getLocations();
	}
}
