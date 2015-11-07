package org.ucm.cis.leis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ucm.cis.leis.dao.ManufacturerDAO;
import org.ucm.cis.leis.models.Manufacturer;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {


	@RequestMapping(value="/viewAddManufacturer", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model1 = new ModelAndView("AddManufacturer");
		
		return model1;
	}

	@ModelAttribute
    public void addingCommonObjects(Model model1) {
		
		model1.addAttribute("headerMessage", "Lab Equipment Inventory System");
	}

	@RequestMapping(value="/submitAddManufacturer", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("manufacturer1") Manufacturer manufacturer1) {

		ModelAndView model1 = new ModelAndView("ManufacturersList");
		//ManufacturerDAO mdao = new ManufacturerDAO();
		//manufacturer1 = mdao.addManufacturer(manufacturer1);
		return model1;
	}
	
}

