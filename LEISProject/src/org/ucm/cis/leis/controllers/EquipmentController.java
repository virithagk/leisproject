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
import org.ucm.cis.leis.models.Equipment;
import org.ucm.cis.leis.service.EquipmentService;


@Controller
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;
	
	@RequestMapping(value = "/saveEquipment", method = RequestMethod.POST)
	public ModelAndView saveEquipment(@ModelAttribute("command") Equipment equipment, 
			BindingResult result) {
		equipmentService.addEquipment(equipment);
		return new ModelAndView("redirect:/addEquipment.html");
	}
	
	@RequestMapping(value = "/addEquipment", method = RequestMethod.GET)
	public ModelAndView addEquipment(@ModelAttribute("command")  Equipment equipment,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipments",  equipmentService.getEquipments());
		return new ModelAndView("addEquipment", model);
	}
	
	@RequestMapping(value = "/deleteEquipment", method = RequestMethod.GET)
	public ModelAndView deleteEquipment(@ModelAttribute("command")  Equipment equipment,
			BindingResult result) {
		equipmentService.deleteEquipment(equipment.getEquipmentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipments",  equipmentService.getEquipments());
		return new ModelAndView("addEquipment", model);
	}
	
	@RequestMapping(value = "/editEquipment", method = RequestMethod.GET)
	public ModelAndView editEquipment(@ModelAttribute("command")  Equipment equipment,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("equipment",  equipmentService.getEquipment(equipment.getEquipmentId()));
		model.put("equipments",  equipmentService.getEquipments());
		return new ModelAndView("addEquipment", model);
	}
	
	@RequestMapping(value="/equipment", method = RequestMethod.GET)
	public List<Equipment> getEquipments() {
		return equipmentService.getEquipments();
	}
}

	

