package org.ucm.cis.leis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ucm.cis.leis.models.PlatformType;
import org.ucm.cis.leis.service.PlatformTypeService;



public class PlatformTypeController {

	@Autowired
	private PlatformTypeService platformTypeService;
	
	@RequestMapping(value = "/savePlatformType", method = RequestMethod.POST)
	public ModelAndView savePlatformType(@ModelAttribute("command") PlatformType platformType, 
			BindingResult result) {
		platformTypeService.addPlatformType(platformType);
		return new ModelAndView("redirect:/addPlatformType.html");
	}
	
	@RequestMapping(value = "/addPlatformType", method = RequestMethod.GET)
	public ModelAndView addPlatformType(@ModelAttribute("command")  PlatformType platformType,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("platformTypes",  platformTypeService.getPlatformTypes());
		return new ModelAndView("addPlatformType", model);
	}
	
	@RequestMapping(value = "/deletePlatformType", method = RequestMethod.GET)
	public ModelAndView deletePlatformType(@ModelAttribute("command")  PlatformType platformType,
			BindingResult result) {
		platformTypeService.deletePlatformType(platformType.getPlatformCode());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("platformTypes",  platformTypeService.getPlatformTypes());
		return new ModelAndView("addPlatformType", model);
	}
	
	@RequestMapping(value = "/editPlatformType", method = RequestMethod.GET)
	public ModelAndView editPlatformType(@ModelAttribute("command")  PlatformType platformType,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("platformType",  platformTypeService.getPlatformType(platformType.getPlatformCode()));
		model.put("platformTypes",  platformTypeService.getPlatformTypes());
		return new ModelAndView("addPlatformType", model);
	}
	
	@RequestMapping(value="/platformTypes", method = RequestMethod.GET)
	public List<PlatformType> getPlatformTypes() {
		
		return platformTypeService.getPlatformTypes();
	}
}
