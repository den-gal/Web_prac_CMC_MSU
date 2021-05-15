package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;
import Services.ClientsServices;
import Services.Impl.ClientsServicesImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Order_ListController {
    private final ClientsServices clientsServices = new ClientsServicesImpl();

    @RequestMapping(value = "/sign_in/order_list/{status}", method = RequestMethod.GET)
    public ModelAndView sign_in_order_create(@PathVariable("status") boolean status, Orders order, Cars car, Clients client){
        ModelAndView modelAndView = new ModelAndView();
        if (status) {
            List<Orders> orders = clientsServices.findOrdersByClientId(client.getClient_id());
            modelAndView.addObject("orders", orders);
            modelAndView.setViewName("orders_list");
        }
        else {
            modelAndView.setViewName("sign_in_again");
        }
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        modelAndView.addObject("order", order);
        return modelAndView;
    }
}
