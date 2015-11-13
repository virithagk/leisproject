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
	public ModelAndView saveModel(@ModelAttribute("command") Model model, 
			BindingResult result) {
		modelService.addModel(model);
		return new ModelAndView("redirect:/addModel.html");
	}
	
	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public ModelAndView addModel(@ModelAttribute("command")  Model model,
			BindingResult result) {
		Map<String, Object> model1 = new HashMap<String, Object>();
		model1.put("models",  modelService.getModels());
		return new ModelAndView("addModel", model1);
	}
	
	@RequestMapping(value = "/deleteModel", method = RequestMethod.GET)
	public ModelAndView deleteModel(@ModelAttribute("command")  Model model,
			BindingResult result) {
		modelService.deleteModel(model.getModelCode());
		Map<String, Object> model1 = new HashMap<String, Object>();
		model1.put("models",  modelService.getModels());
		return new ModelAndView("addModel", model1);
	}
	
	@RequestMapping(value = "/editModel", method = RequestMethod.GET)
	public ModelAndView editModel(@ModelAttribute("command")  Model model,
			BindingResult result) {
		Map<String, Object> model1 = new HashMap<String, Object>();
		model1.put("model",  modelService.getModel(model.getModelCode()));
		model1.put("models",  modelService.getModels());
		return new ModelAndView("addModel", model1);
	}
	
	@RequestMapping(value="/models", method = RequestMethod.GET)
	public List<Model> getModels() {
		return modelService.getModels();
	}
}
