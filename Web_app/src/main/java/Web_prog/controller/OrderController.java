package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;
import Services.OrdersServices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    private final OrdersServices ordersServices = new OrdersServicesImpl();
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();

    @RequestMapping(value = "/confirm_form/checkout/order", method = RequestMethod.GET)
    public ModelAndView order_create(Cars car){
        ModelAndView modelAndView = new ModelAndView();
        Orders order = new Orders();
        modelAndView.addObject("order", order);
        modelAndView.addObject("car", car);
        modelAndView.setViewName("order_create");
        return modelAndView;
    }
    @RequestMapping(value = "/order/sign_in", method = RequestMethod.POST)
    public ModelAndView order_create_post(@ModelAttribute("order") Orders order, @ModelAttribute("car") Cars car){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:sign_in");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/checkout/order", method = RequestMethod.GET)
    public ModelAndView sign_in_order_create(Cars car, Clients client){
        ModelAndView modelAndView = new ModelAndView();
        Orders order = new Orders();
        modelAndView.addObject("order", order);
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("order_create");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/order_list", method = RequestMethod.POST)
    public ModelAndView sign_in_order_create_post(@ModelAttribute("order") Orders order, @ModelAttribute("car") Cars car,@ModelAttribute("client") Clients client){
        ModelAndView modelAndView = new ModelAndView();
        car.addClient_id(client);
        client.addOrder(order);
        order.setCar_id(car);
        ordersServices.save(order);
        carsServices.save(car);
        clientsServices.save(client);
        modelAndView.setViewName("redirect:orders_list");
        return modelAndView;
    }
}
