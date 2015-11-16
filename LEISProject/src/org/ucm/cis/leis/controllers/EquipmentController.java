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
import org.ucm.cis.leis.models.Equipment;
import org.ucm.cis.leis.service.EquipmentService;
import org.ucm.cis.leis.service.EquipmentTypeService;
import org.ucm.cis.leis.service.FundingSourceService;
import org.ucm.cis.leis.service.LocationService;
import org.ucm.cis.leis.service.ManufacturerService;
import org.ucm.cis.leis.service.ModelService;
import org.ucm.cis.leis.service.StatusService;


@Controller
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private ManufacturerService manufacturerService;

	@Autowired
	private EquipmentTypeService equipmentTypeService;

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private StatusService statusService;

	@Autowired
	private FundingSourceService fundingSourceService;

	@Autowired
	private LocationService locationService;

	
	
	@RequestMapping(value = "/saveEquipment", method = RequestMethod.POST)
	public ModelAndView saveEquipment(@ModelAttribute("command") Equipment equipment, 
			BindingResult result, HttpServletRequest request) {
		equipmentService.addEquipment(equipment);
		return new ModelAndView("redirect:/addEquipment.html");
	}
	
	@RequestMapping(value = "/addEquipment", method = RequestMethod.GET)
	public ModelAndView addEquipment(@ModelAttribute("command")  Equipment equipment,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipments",  equipmentService.getEquipments());
		
		model.put("manufacturers",  manufacturerService.getManufacturers());
		model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
		model.put("models",  modelService.getModels());
		model.put("statuses",  statusService.getStatuses());
		model.put("fundingSources",  fundingSourceService.getFundingSources());
		model.put("locations",  locationService.getLocations());
		
		return new ModelAndView("addEquipment", model);
	}
	
	@RequestMapping(value = "/deleteEquipment", method = RequestMethod.GET)
	public ModelAndView deleteEquipment(@ModelAttribute("command")  Equipment equipment,
			BindingResult result, HttpServletRequest request) {
		equipmentService.deleteEquipment(equipment.getEquipmentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipments",  equipmentService.getEquipments());
		
		model.put("manufacturers",  manufacturerService.getManufacturers());
		model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
		model.put("models",  modelService.getModels());
		model.put("statuses",  statusService.getStatuses());
		model.put("fundingSources",  fundingSourceService.getFundingSources());
		model.put("locations",  locationService.getLocations());

		return new ModelAndView("addEquipment", model);
	}
	
	@RequestMapping(value = "/editEquipment", method = RequestMethod.GET)
	public ModelAndView editEquipment(@ModelAttribute("command")  Equipment equipment,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipment",  equipmentService.getEquipment(equipment.getEquipmentId()));
		model.put("equipments",  equipmentService.getEquipments());

		model.put("manufacturers",  manufacturerService.getManufacturers());
		model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
		model.put("models",  modelService.getModels());
		model.put("statuses",  statusService.getStatuses());
		model.put("fundingSources",  fundingSourceService.getFundingSources());
		model.put("locations",  locationService.getLocations());

		return new ModelAndView("addEquipment", model);
	}
	
	@RequestMapping(value="/equipments", method = RequestMethod.GET)
	public List<Equipment> getEquipments() {
		return equipmentService.getEquipments();
	}
	
	
	@RequestMapping(value = "/showReports", method = RequestMethod.GET)
	public ModelAndView showReports(@ModelAttribute("command")  Equipment equipment,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipments",  equipmentService.getEquipments());
		
		/*model.put("manufacturers",  manufacturerService.getManufacturers());
		model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
		model.put("models",  modelService.getModels());
		model.put("statuses",  statusService.getStatuses());
		model.put("fundingSources",  fundingSourceService.getFundingSources());*/
		model.put("locations",  locationService.getLocations());
		
		return new ModelAndView("generateReports", model);
	}
}

	

