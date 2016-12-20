package com.himalayanGeeks.carRental.controller;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.Role;
import com.himalayanGeeks.carRental.domain.User;
import com.himalayanGeeks.carRental.service.UserService;

//HomeController defines which page to be opened at the begining of the application.
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	
	/*
	@RequestMapping(value = "/addCar", method = RequestMethod.GET)
	public String addCar(@ModelAttribute("car") Car car) {
		System.out.println("------------------addCar method invoked---------------------");
		
		return "addCar";
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String saveCar(@ModelAttribute("car")Car car,Model model) {
		
		System.out.println("------------------addCar method invoked---------------------");
		System.out.println("------------"+car.getName());
		return "addCar";
	}*/
	
/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("user") User user,RedirectAttributes redirectAttrs) {
		System.out.println("------------------login get method invoked---------------------");
		
		return "login";
		
	}*/
	

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String createAdmin(@ModelAttribute("user") User user) {
		System.out.println("------------------addUser method invoked---------------------");
		
		return "addUser";
	}
	
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String getUsers(Model model) {
		System.out.println("------------------addUser method invoked---------------------");
		List<User>users=userService.getAll();
		model.addAttribute("userList", users);
		return "userList";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		userService.delete(id);
		 return "redirect:/admin/userList";
	}

	
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model){
		System.out.println("------------------------------"+id);
	  	User user=userService.findById(id);
	  	System.out.println("------------------------------"+user.getFirstName());
	    model.addAttribute("user", user);
	   return "edit";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUser(@Valid @ModelAttribute("user")User user, BindingResult bindingResult, RedirectAttributes redirectAttrs){
		System.out.println("Hello--------------------------------------------------------");
		  if (bindingResult.hasErrors()) {
	            return "addUser";
	        }
    userService.edit(user);
       redirectAttrs.addFlashAttribute("message",user.firstName+"  "+user.lastName+" Successfully edited");
	    return "redirect:/admin/userList";
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String newUser(@Valid @ModelAttribute("user")User user, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        String newpassword = this.MD5(user.getPassword());
		user.setPassword(newpassword);
		Role role = new Role();
		role.setId(RandomUtils.nextLong());
		role.setRole(1);
		role.setUser(user);
		user.setRole(role);
		userService.save(user);
		redirectAttrs.addFlashAttribute("message","Welcome "+ user.firstName+"  "+user.lastName+" Now login with your username and password for access, Your Email is username ");      
      System.out.println("------------------addUser post method invoked---------------------");
		
      
      redirectAttrs.addFlashAttribute("message",user.firstName+"  "+user.lastName+" Successfully added as "+user.getRole().getRole());
  	System.out.println(user.firstName+"  "+user.lastName+" Successfully added as "+user.getRole().getRole());
      return "redirect:/admin/home";/* here I've redirected to user ..
       same page i defined.. later we can send to other pages for landing
       this is done just to show flash message*/
      
	}
	
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
}
