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
import org.ucm.cis.leis.models.Model;
import org.ucm.cis.leis.service.ModelService;


@Controller
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public ModelAndView saveModel(@ModelAttribute("command") Model aModel, 
			BindingResult result) {
		modelService.addModel(aModel);
		return new ModelAndView("redirect:/addModel.html");
	}
	
	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public ModelAndView addModel(@ModelAttribute("command")  Model aModel,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("aModel",  modelService.getModels());
		return new ModelAndView("addModel", model);
	}
	
	@RequestMapping(value = "/deleteModel", method = RequestMethod.GET)
	public ModelAndView deleteModel(@ModelAttribute("command")  Model aModel,
			BindingResult result) {
		modelService.deleteModel(aModel.getModelCode());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("aModel",  modelService.getModels());
		return new ModelAndView("addModel", model);
	}
	
	@RequestMapping(value = "/editModel", method = RequestMethod.GET)
	public ModelAndView editModel(@ModelAttribute("command")  Model aModel,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("aModel",  modelService.getModel(aModel.getModelCode()));
		model.put("aModel",  modelService.getModels());
		return new ModelAndView("addModel", model);
	}
	
	@RequestMapping(value="/aModel", method = RequestMethod.GET)
	public List<Model> getModel() {
		return modelService.getModels();
	}
}
