package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.CarsServicesImpl;

import Services.Impl.ClientsServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();

    @RequestMapping(value = "/confirm_form/checkout/{id}", method = RequestMethod.GET)
    public ModelAndView checkout(@PathVariable("id") int id) {
        Cars car = carsServices.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout");
        Clients client = new Clients();
        client.setLogin(null);
        modelAndView.addObject("client", client);
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/checkout/{id}/{client_id}", method = RequestMethod.GET)
    public ModelAndView sign_in_checkout(@PathVariable("id") int id, @PathVariable("client_id") int client_id) {
        Cars car = carsServices.findById(id);
        Clients client = clientsServices.findById(client_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout");
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        return modelAndView;
    }
}
