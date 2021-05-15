package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;

import Classes.Form;
import Services.CarsServices;
import Services.Impl.CarsServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
    private final CarsServices carsServices = new CarsServicesImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView start_page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start_page");
        Cars car_inf = new Cars();
        Form form = carsServices.searchDB();
        modelAndView.addObject("form", form);
        modelAndView.addObject("car_inf", car_inf);
        return modelAndView;
    }

    @RequestMapping(value = "/confirm_form", method = RequestMethod.POST)
    public ModelAndView start_page_post(@ModelAttribute("car_inf") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm_form");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/start_page/{status}", method = RequestMethod.GET)
    public ModelAndView sign_in_start_page(@PathVariable("status") boolean status, Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        if (status) {
            modelAndView.setViewName("start_page");
            Cars car_inf = new Cars();
            Form form = carsServices.searchDB();
            modelAndView.addObject("form", form);
            modelAndView.addObject("car_inf", car_inf);
        }
        else {
            modelAndView.setViewName("sign_in_again");
        }
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/confirm_form", method = RequestMethod.POST)
    public ModelAndView sign_in_start_page_post(@ModelAttribute("car_inf") Cars car, @ModelAttribute("client") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm_form");
        return modelAndView;
    }
}
