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
import org.ucm.cis.leis.models.EquipmentType;
import org.ucm.cis.leis.service.EquipmentTypeService;


	@Controller
	public class EquipmentTypeController {

		@Autowired
		private EquipmentTypeService equipmentTypeService;
		
		@RequestMapping(value = "/saveEquipmentType", method = RequestMethod.POST)
		public ModelAndView saveEquipmentType(@ModelAttribute("command") EquipmentType equipmentType, 
				BindingResult result, HttpServletRequest request) {
			equipmentTypeService.addEquipmentType(equipmentType);
			return new ModelAndView("redirect:/addEquipmentType.html");
		}
		
		@RequestMapping(value = "/addEquipmentType", method = RequestMethod.GET)
		public ModelAndView addEquipmentType(@ModelAttribute("command")  EquipmentType equipmentType,
				BindingResult result, HttpServletRequest request) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
			return new ModelAndView("addEquipmentType", model);
		}
		
		@RequestMapping(value = "/deleteEquipmentType", method = RequestMethod.GET)
		public ModelAndView deleteEquipment(@ModelAttribute("command")  EquipmentType equipmentType,
				BindingResult result, HttpServletRequest request) {
			equipmentTypeService.deleteEquipmentType(equipmentType.getTypeCode());
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
			return new ModelAndView("addEquipmentType", model);
		}
		
		@RequestMapping(value = "/editEquipmentType", method = RequestMethod.GET)
		public ModelAndView editEquipmentType(@ModelAttribute("command")  EquipmentType equipmentType,
				BindingResult result, HttpServletRequest request) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("equipmentType",  equipmentTypeService.getEquipmentType(equipmentType.getTypeCode()));
			model.put("equipmentTypes",  equipmentTypeService.getEquipmentTypes());
			return new ModelAndView("addEquipmentType", model);
		}
		
		@RequestMapping(value="/equipmentTypes", method = RequestMethod.GET)
		public List<EquipmentType> getEquipmentTypes() {
			return equipmentTypeService.getEquipmentTypes();
		}
	}

		



