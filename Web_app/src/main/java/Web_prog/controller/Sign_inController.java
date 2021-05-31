package Web_prog.controller;

import Classes.Clients;
import Classes.Orders;
import Classes.Cars;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;
import Services.OrdersServices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sign_inController {
    private final OrdersServices ordersServices = new OrdersServicesImpl();
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public ModelAndView sign_in() {
        ModelAndView modelAndView = new ModelAndView();
        Clients client = new Clients();
        Cars car = new Cars();
        car.setBrand(null);
        modelAndView.addObject("car", car);
        modelAndView.addObject("client_inf", client);
        modelAndView.addObject("start_page", true);
        modelAndView.setViewName("sign_in");
        return modelAndView;
    }

    @RequestMapping(value = "/order/sign_in/{id}", method = RequestMethod.GET)
    public ModelAndView order_sign_in(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Cars car = carsServices.findById(id);
        Clients client = new Clients();
        modelAndView.addObject("car", car);
        modelAndView.addObject("client_inf", client);
        modelAndView.addObject("start_page", false);
        modelAndView.setViewName("sign_in");
        return modelAndView;
    }
}
