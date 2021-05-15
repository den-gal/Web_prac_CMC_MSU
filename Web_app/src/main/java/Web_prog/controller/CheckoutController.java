package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;
import Services.CarsServices;
import Services.Impl.CarsServicesImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {
    private final CarsServices carsServices = new CarsServicesImpl();

    @RequestMapping(value = "/confirm_form/checkout/{id}", method = RequestMethod.GET)
    public ModelAndView checkout(@PathVariable("id") int id) {
        Cars car = carsServices.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout");
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @RequestMapping(value = "/confirm_form/checkout/order", method = RequestMethod.POST)
    public ModelAndView checkout_post(@ModelAttribute("car") Cars car){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:order_create");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/checkout/{id}", method = RequestMethod.GET)
    public ModelAndView sign_in_checkout(@PathVariable("id") int id, Clients client) {
        Cars car = carsServices.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout");
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/checkout/order", method = RequestMethod.POST)
    public ModelAndView sign_in_checkout_post(@ModelAttribute("car") Cars car, @ModelAttribute("client") Clients client){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:order_create");
        return modelAndView;
    }
}
