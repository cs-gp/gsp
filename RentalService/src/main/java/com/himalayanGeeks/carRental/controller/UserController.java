package com.himalayanGeeks.carRental.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.CarType;
import com.himalayanGeeks.carRental.domain.CompositeCarModel;
import com.himalayanGeeks.carRental.domain.Insurance;
import com.himalayanGeeks.carRental.domain.Reservation;
import com.himalayanGeeks.carRental.domain.Role;
import com.himalayanGeeks.carRental.domain.User;

import com.himalayanGeeks.carRental.service.CarService;
import com.himalayanGeeks.carRental.service.InsuranceService;
import com.himalayanGeeks.carRental.service.ReservationService;
import com.himalayanGeeks.carRental.service.UserService;
import com.himalayanGeeks.carRental.serviceImpl.CustomUserDetailsService;
@Controller
@RequestMapping("/user")
@SessionAttributes("loggedUser")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	CarService carService;
	@Autowired
    CustomUserDetailsService cus;
	@Autowired
	InsuranceService insser;
	@Autowired
	ReservationService resser;
	

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String addCar(@ModelAttribute("user") User user) {
		System.out.println("------------------User Signup method invoked---------------------");
		
		return "signUp";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String addCar(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttrs)  {
		if(result.hasErrors()){
		return "signUp";
	}
		String newpassword = this.MD5(user.getPassword());
		user.setPassword(newpassword);
		Role role = new Role();
		role.setId(RandomUtils.nextLong());
		role.setRole(2);
		role.setUser(user);
		user.setRole(role);
		userservice.save(user);
		redirectAttrs.addFlashAttribute("message","Welcome "+ user.firstName+"  "+user.lastName+" Now login with your username and password for access, Your Email is username ");
		return "redirect:/login";
	}
		
	
	@RequestMapping(value = "/searchCarFormPost", method = RequestMethod.GET)
	public String list(@ModelAttribute("Reservation") Reservation reservation,Model model) {
		System.out.println("incarget");
		model.addAttribute("loggedUser", cus.getSessionUser());
		return "listCars";
	}
	
	
	@RequestMapping(value = "/myreservation", method = RequestMethod.GET)
	public String login() {
		return "ReservationList";
	}
	
	@RequestMapping(value = "/continueCheckout/{id}", method = RequestMethod.GET)
	public String continueCheckout(@PathVariable("id") Integer id, Model model) {

		System.out.println("id" + id);
		System.out.println(CompositeCarModel.getReservationInstance().getPickuplocation());
		Car car = carService.getCarById(id);
		car.setAvailable(false);
		List<Insurance> insuranceList = insser.getAllInsurance();	
		CompositeCarModel.setCar(car);
		model.addAttribute("insuranceList", insuranceList);
		return "addInsurance";

	}

	@RequestMapping(value = "/searchCarFormPost", method = RequestMethod.POST)
	public String searchCarFormPost(@ModelAttribute("Reservation") Reservation reservation, Model model) {
		System.out.println("invoked");
		System.out.println(reservation.pickupdate);
		CompositeCarModel.setReservation(reservation);	
		List<Car> carList = carService.findavailableCar();
		CompositeCarModel.setCarList(carList);			
		model.addAttribute("compositeModel", CompositeCarModel.getCarList());		
		return "listCars";
	}
	
	@RequestMapping(value = "/billWithInsurance/{id}", method = RequestMethod.GET)
	public String continueCheckout(Model model,@PathVariable("id") Integer id) {
				Insurance selectedinsurance = insser.getInsuranceById(id);
				
				
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String username;
				if (principal instanceof UserDetails) {
				  username = ((UserDetails)principal).getUsername();
				} else {
				  username = principal.toString();
				}
				carService.delete(CompositeCarModel.getCarInstance().getId());
				carService.save(CompositeCarModel.getCarInstance());
				
				
				CompositeCarModel.getCarInstance().setInsurance(selectedinsurance);
				CompositeCarModel.getReservationInstance().setCar(CompositeCarModel.getCarInstance());
				resser.save(CompositeCarModel.getReservationInstance());	
				
				User user = userservice.findByUsername(username);				
				List<Reservation> reserv = user.getReservation();				
				reserv.add(CompositeCarModel.getReservationInstance());				
				user.setReservation(reserv);
				
				
				userservice.delete(user.getId());
				userservice.save(user);
				
				
				
				model.addAttribute("carwithinsurance",CompositeCarModel.getCarInstance());
				model.addAttribute("reservationcar",CompositeCarModel.getReservationInstance());
				String[] splittedDate=CompositeCarModel.getReservationInstance().pickupdate.split("-");
				System.out.println(splittedDate[0]);
				Calendar cal = Calendar.getInstance();
		        cal.set(Calendar.YEAR, Integer.parseInt(splittedDate[0]));
		        cal.set(Calendar.MONTH, Integer.parseInt(splittedDate[1]));
		        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splittedDate[2]));
		        
		    	String[] splittedDate1=CompositeCarModel.getReservationInstance().dropoffdate.split("-");
				System.out.println(splittedDate1[0]);
				Calendar cal1 = Calendar.getInstance();
				cal1.set(Calendar.YEAR, Integer.parseInt(splittedDate1[0]));
				cal1.set(Calendar.MONTH, Integer.parseInt(splittedDate1[1]));
				cal1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splittedDate1[2]));
		        
				Date d1=cal1.getTime();
				Date d2=cal.getTime();
				
			    long diffInDays= d1.getTime()-  d2.getTime();
				System.out.println( diffInDays / (1000 * 60 * 60 * 24));
				int totaldays = (int)diffInDays / (1000 * 60 * 60 * 24);
				model.addAttribute("numberofDays", totaldays);
				int totalcar = CompositeCarModel.getCarInstance().getPricePerDay()*totaldays;
				int totalWithInsurance = CompositeCarModel.getCarInstance().getInsurance().getCostPerDay()*totaldays;
				int totalCost = totalcar+totalWithInsurance;
				model.addAttribute("total",totalCost);
				model.addAttribute("cartotal",totalcar);
				model.addAttribute("insurancetotal",totalWithInsurance);
		
		
		return "bill";

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
