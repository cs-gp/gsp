package com.himalayanGeeks.carRental.controller;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.CarType;
import com.himalayanGeeks.carRental.domain.Insurance;
import com.himalayanGeeks.carRental.service.CarService;
import com.himalayanGeeks.carRental.service.InsuranceService;
import com.himalayanGeeks.carRental.serviceImpl.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by Vikas on 8/31/2016.
 */
@Controller
@RequestMapping(value={"/admin"})
@SessionAttributes("luser")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    CustomUserDetailsService cus;
    @Autowired
    InsuranceService inser;

    @RequestMapping(value = "/home")
    public String carList(Model model) {
        List<Car> carList = carService.getAllCars();
        model.addAttribute("carList", carList);
        try{
    		model.addAttribute("luser", cus.getSessionUser());
    		}
    		catch(Exception e){
    			throw e;
    }
        return "adminHome";
        
    }

    @RequestMapping(value = "/addverynewCar", method = RequestMethod.GET)
    public String addCar(@ModelAttribute("verynewCar") Car car) {
        System.out.println("------------------addCar method invoked---------------------");

        return "addCar";
    }

    @RequestMapping(value = "/addCarType", method = RequestMethod.GET)
    public String addCarType(@ModelAttribute("carType") CarType carType) {
        System.out.println("------------------addCarType method invoked---------------------");

        return "addCarType";
    }

    @RequestMapping(value = "/addverynewCar", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("verynewCar")Car car, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        System.out.println("------------------addCar method invoked in post---------------------");
        System.out.println("------------" + car.getName());
        car.setAvailable(true);
        MultipartFile carImage = car.getCarImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);

        //isEmpty means file exists BUT NO Content
        if (carImage != null && !carImage.isEmpty()) {
            try {
                carImage.transferTo(new File(rootDirectory + "\\resources\\images\\" + car.getName() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException(" Image saving failed", e);
            }
        }
        carService.save(car);
        redirectAttributes.addFlashAttribute("car", car);
        return "redirect:/admin/home";
    }
    @RequestMapping(value = "/editCar/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        System.out.println("------------------------------"+id);
        Car carToBeEdit= carService.getCarById(id);
        System.out.println("------------------------------"+carToBeEdit.getName());
        model.addAttribute("car", carToBeEdit);
        return "carDetails";
    }
    @RequestMapping(value = "/editCar", method = RequestMethod.POST)
    public String editCar(@ModelAttribute("car") Car carToBeAdded, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        System.out.println("------------------editCar method invoked in post---------------------");
        System.out.println("------------" + carToBeAdded.getName());
        carService.delete(carToBeAdded.getId());
        MultipartFile carImage = carToBeAdded.getCarImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);

        //isEmpty means file exists BUT NO Content
        if (carImage != null && !carImage.isEmpty()) {
            try {
                carImage.transferTo(new File(rootDirectory + "\\resources\\images\\" + carToBeAdded.getName() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException(" Image saving failed", e);
            }
        }
        carService.save(carToBeAdded);
        redirectAttributes.addFlashAttribute("car", carToBeAdded);
        return "redirect:/cars";
    }
    @RequestMapping(value = "/deleteCar/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        carService.delete(id);
        return "redirect:/cars";
    }

    @RequestMapping("/car/{id}")
    public String getProductById(Model model, @RequestParam("id") String carId) {

        Car car = carService.getCarById(Integer.parseInt(carId));
        model.addAttribute("car", car);
        return "carDetails";
    }

    @RequestMapping("/car/{name}")
    public String getCarByName(Model model, @RequestParam("name") String name) {
        Car car = carService.getCarByName(name);
        model.addAttribute("car",car);
        return "adminHome";
    }
    

    @RequestMapping(value = "/addNewInsurance", method = RequestMethod.GET)
    public String addInsurance(@ModelAttribute("newInsurance") Insurance isnurance) {
        System.out.println("------------------addInsurance method invoked---------------------");
        return "addNewInsurance";
    }
    
    @RequestMapping(value = "/addNewInsurance", method = RequestMethod.POST)
    public String saveInsurance(@ModelAttribute("newInsurance") Insurance isnurance) {
        System.out.println("------------------addInsurance method invoked in post---------------------");
        inser.save(isnurance);
        System.out.println(isnurance.getName());
        return "adminHome";
    }
    
    


}
