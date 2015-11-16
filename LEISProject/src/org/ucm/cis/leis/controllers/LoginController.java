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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.ucm.cis.leis.models.Login;
import org.ucm.cis.leis.service.LoginService;

@Controller
@SessionAttributes("loginObj")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/*
	 * @RequestMapping(value = "/showLogin.html", method=RequestMethod.GET)
	 * public ModelAndView showLogin() { //Map<String, Object> model = new
	 * HashMap<String, Object>(); //model.put("logins",
	 * loginService.getLogins()); return new ModelAndView("leis_login"); }
	 */

	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public ModelAndView displayLogin(@ModelAttribute("command") Login login,
			BindingResult result, HttpServletRequest request) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("login", new Login());
		//model.put(key, value)
		return new ModelAndView("leis_login", model);
	}

	/*@RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
	public ModelAndView manageUsers(@ModelAttribute("command") Login login,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("login", login);
		//model.put(key, value)
		return new ModelAndView("manageUsers", model);
	}*/

	/*
	 * @RequestMapping(value = "/addLogin", method = RequestMethod.GET) public
	 * ModelAndView addLogin(@ModelAttribute("command") Login login,
	 * BindingResult result) { Map<String, Object> model = new HashMap<String,
	 * Object>(); model.put("logins", loginService.getLogins()); return new
	 * ModelAndView("addLogin", model); }
	 */

	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("command") Login login,
			BindingResult result, Model model1, HttpServletRequest request) {
		Login loginFromDB = loginService.getLogin(login.getUserName());
		
		if (null != loginFromDB && null != loginFromDB.getPassword()
				&& null != login.getPassword()
				&& login.getPassword().equals(loginFromDB.getPassword())) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("login", loginFromDB);
			ModelAndView model2 = new ModelAndView("redirect:/manageUsers.html");
			 request.getSession().setAttribute("curLogin", loginFromDB);
			model2.addObject("loginObj",loginFromDB);
			return model2;
		} else {
			ModelAndView model = new ModelAndView("leis_login");
			model.addObject("errorMsg", "Invalid Credentials");
			return model;
		}
	}
	
	@RequestMapping(value = "/saveLogin", method = RequestMethod.POST)
	public ModelAndView saveLogin(@ModelAttribute("command") Login login, 
			BindingResult result, HttpServletRequest request) {
		loginService.addLogin(login);
		return new ModelAndView("redirect:/manageUsers.html");
	}
	
	@RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
	public ModelAndView addLogin(@ModelAttribute("command")  Login login,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> login1 = new HashMap<String, Object>();
		login1.put("logins",  loginService.getLogins());
		return new ModelAndView("manageUsers", login1);
	}
	
	@RequestMapping(value = "/deleteLogin", method = RequestMethod.GET)
	public ModelAndView deleteLogin(@ModelAttribute("command")  Login login,
			BindingResult result, HttpServletRequest request) {
		loginService.deleteLogin(login.getUserName());
		Map<String, Object> login1 = new HashMap<String, Object>();
		login1.put("logins",  loginService.getLogins());
		return new ModelAndView("manageUsers", login1);
	}
	
	@RequestMapping(value = "/editLogin", method = RequestMethod.GET)
	public ModelAndView editLogin(@ModelAttribute("command")  Login login,
			BindingResult result, HttpServletRequest request) {
		Map<String, Object> login1 = new HashMap<String, Object>();
		login1.put("login",  loginService.getLogin(login.getUserName()));
		login1.put("logins",  loginService.getLogins());
		return new ModelAndView("manageUsers", login1);
	}
	
	@RequestMapping(value="/logins", method = RequestMethod.GET)
	public List<Login> getLogins() {
		return loginService.getLogins();
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("command") Login login,
			BindingResult result, Model model1, HttpServletRequest request) {
		
		Login l = (Login) request.getSession().getAttribute("curLogin");
		
		if(l!=null) {
			
		//System.out.println("%%%%%%%%%%%%%%blah blah blah%%%Username ::"+ l.getUserName()+ "  efwesdfsgdfg ");
			
		}
		ModelAndView model = new ModelAndView("changePassword");
		return model;
		}
	
}
