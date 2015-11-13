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
import org.ucm.cis.leis.models.FundingSource;
import org.ucm.cis.leis.service.FundingSourceService;


@Controller
public class FundingSourceController {


	@Autowired
	private FundingSourceService fundingSourceService;
	
	@RequestMapping(value = "/saveFundingSource", method = RequestMethod.POST)
	public ModelAndView saveFundingSource(@ModelAttribute("command") FundingSource fundingSource, 
			BindingResult result) {
		fundingSourceService.addFundingSource(fundingSource);
		return new ModelAndView("redirect:/addFundingSource.html");
	}
	
	@RequestMapping(value = "/addFundingSource", method = RequestMethod.GET)
	public ModelAndView addFundingSource(@ModelAttribute("command")  FundingSource fundingSource,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fundingSources",  fundingSourceService.getFundingSources());
		return new ModelAndView("addFundingSource", model);
	}
	
	@RequestMapping(value = "/deleteFundingSource", method = RequestMethod.GET)
	public ModelAndView deleteFundingSource(@ModelAttribute("command")  FundingSource fundingSource,
			BindingResult result) {
		fundingSourceService.deleteFundingSource(fundingSource.getFundingSourceId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fundingSources",  fundingSourceService.getFundingSources());
		return new ModelAndView("addFundingSource", model);
	}
	
	@RequestMapping(value = "/editFundingSource", method = RequestMethod.GET)
	public ModelAndView editFundingSource(@ModelAttribute("command")  FundingSource fundingSource,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fundingSource",  fundingSourceService.getFundingSource(fundingSource.getFundingSourceId()));
		model.put("fundingSources",  fundingSourceService.getFundingSources());
		return new ModelAndView("addFundingSource", model);
	}
	
	@RequestMapping(value="/fundingSources", method = RequestMethod.GET)
	public List<FundingSource> getFundingSources() {
		return fundingSourceService.getFundingSources();
	}

}
