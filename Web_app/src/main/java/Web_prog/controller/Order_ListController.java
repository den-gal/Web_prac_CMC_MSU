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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class Order_ListController {
    private final OrdersServices ordersServices = new OrdersServicesImpl();
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();

    @RequestMapping(value = "/order_list/{id}/{client_id}",method = RequestMethod.POST)
    public ModelAndView order_list(@ModelAttribute("order") Orders new_order, @PathVariable("id") int id, @PathVariable("client_id") int client_id) {
        ModelAndView modelAndView = new ModelAndView();
        Cars car = carsServices.findById(id);
        Clients client = clientsServices.findById(client_id);
        Orders order = new Orders(car, client, new_order.isTest_drive(), java.sql.Date.valueOf(LocalDate.now()), "new");
        //carsServices.addClientToCar(car, client);
        clientsServices.addOrderToClient(client, order);
        ordersServices.save(order);
        modelAndView.addObject("order", order);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("redirect:/order_list/{client_id}");
        return modelAndView;
    }

    @RequestMapping(value = "/order_list/{client_id}",method = RequestMethod.GET)
    public ModelAndView order_list_get(@PathVariable("client_id") int client_id){
        ModelAndView modelAndView = new ModelAndView();
        Clients client = clientsServices.findById(client_id);
        List<Orders> orders = clientsServices.findOrdersByClientId(client_id);
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("orders_list");
        return modelAndView;
    }
}
