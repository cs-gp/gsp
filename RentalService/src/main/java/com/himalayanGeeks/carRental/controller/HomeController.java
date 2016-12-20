package com.himalayanGeeks.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.himalayanGeeks.carRental.serviceImpl.CustomUserDetailsService;

//HomeController defines which page to be opened at the begining of the application.
@Controller
@SessionAttributes("user")
public class HomeController {
	@Autowired
	CustomUserDetailsService cus;

	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("inhomeget");
		return "welcome";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("inhomeget");
		return "login";
	}
	
	/*@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String openAdmin() {
		System.out.println("inadminget");
		return "adminHome";
		/postLogin
	}*/
	
	@RequestMapping(value="/postLogin" , method= RequestMethod.GET)
	public String afterLogin(Model model) {
		 try{
	    		model.addAttribute("user", cus.getSessionUser());
	    		}
	    		catch(Exception e){
	    			throw e;
	    }
		System.out.println("after login" + cus.getSessionUser().getEmail());
 		return "redirect:/welcome";
 	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "redirect:/welcome";
 	}
	
	@RequestMapping(value="/denied", method = RequestMethod.GET)
	public String error(Model model) {
 		return "redirect:/error-forbidden";
 	}
	
	

}
