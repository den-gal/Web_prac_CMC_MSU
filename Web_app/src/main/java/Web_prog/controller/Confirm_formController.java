package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;
import Services.CarsServices;
import Services.Impl.CarsServicesImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Confirm_formController {
    private final CarsServices carsServices = new CarsServicesImpl();

    @RequestMapping(value = "/confirm_form", method = RequestMethod.GET)
    public ModelAndView allCars(Cars car){
        ModelAndView modelAndView = new ModelAndView();
        List<Cars> cars = carsServices.findCarsByCarNot(car.getBrand(), car.getManufacturer(), car.getTechnical_not(), car.getAddition_devices(), car.getCostumer_not(), car.getMutable_not());
        modelAndView.setViewName("confirm_form");
        modelAndView.addObject("carsList", cars);
        return modelAndView;
    }

    @RequestMapping(value = "/confirm_form/checkout/{id}", method = RequestMethod.POST)
    public ModelAndView allCars_post(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:checkout");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/confirm_form", method = RequestMethod.GET)
    public ModelAndView sign_in_allCars(Cars car, Clients client){
        ModelAndView modelAndView = new ModelAndView();
        List<Cars> cars = carsServices.findCarsByCarNot(car.getBrand(), car.getManufacturer(), car.getTechnical_not(), car.getAddition_devices(), car.getCostumer_not(), car.getMutable_not());
        modelAndView.setViewName("confirm_form");
        modelAndView.addObject("carsList", cars);
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/checkout/{id}", method = RequestMethod.POST)
    public ModelAndView sign_in_allCars_post(@PathVariable("id") int id, @ModelAttribute("client") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:checkout");
        return modelAndView;
    }
}
