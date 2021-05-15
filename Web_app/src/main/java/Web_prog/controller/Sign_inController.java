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
        modelAndView.addObject("client", client);
        modelAndView.setViewName("sign_in");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/start_page/{status}", method = RequestMethod.POST)
    public ModelAndView sign_in_post(@PathVariable("status") boolean status,@ModelAttribute("client") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        Clients authorized_client = clientsServices.authorizeClient(client.getLogin(), client.getPassword());
        status = authorized_client != null;
        if(status)
            modelAndView.setViewName("redirect:start_page");
        else
            modelAndView.setViewName("redirect:sign_in_again");
        return modelAndView;
    }

    @RequestMapping(value = "/order/sign_in", method = RequestMethod.GET)
    public ModelAndView order_sign_in(Orders order, Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        Clients client = new Clients();
        modelAndView.addObject("order", order);
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("sign_in");
        return modelAndView;
    }

    @RequestMapping(value = "/order/sign_in/order_list/{status}", method = RequestMethod.POST)
    public ModelAndView order_sign_in_post(@PathVariable("status") boolean status,@ModelAttribute("order") Orders order, @ModelAttribute("car") Cars car, @ModelAttribute("client") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        Clients authorized_client = clientsServices.authorizeClient(client.getLogin(), client.getPassword());
        status = authorized_client != null;
        if(status) {
            car.addClient_id(client);
            client.addOrder(order);
            order.setCar_id(car);
            ordersServices.save(order);
            carsServices.save(car);
            clientsServices.save(client);
            modelAndView.setViewName("redirect:orders_list");
        }
        else
            modelAndView.setViewName("redirect:sign_in_again");
        return modelAndView;
    }
}
