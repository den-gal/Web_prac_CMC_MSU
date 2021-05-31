package Web_prog.controller;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;
import Services.AdminServices;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.AdminServicesImpl;
import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;

import java.sql.Date;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();
    private final AdminServices adminServices = new AdminServicesImpl();

    @RequestMapping(value = "/confirm_form/checkout/order/{id}/{client_id}", method = RequestMethod.GET)
    public ModelAndView order_create(@PathVariable("id") int id, @PathVariable("client_id") int client_id){
        Clients client = clientsServices.findById(client_id);
        Cars car = carsServices.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        Date date = java.sql.Date.valueOf(LocalDate.now());
        Orders order = new Orders(car,client,true, date,"new");
        modelAndView.addObject("order", order);
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("order_create");
        return modelAndView;
    }
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ModelAndView sign_in_order_create(@PathVariable("id") int id, @ModelAttribute("client_inf") Clients client){
        ModelAndView modelAndView = new ModelAndView();
        Admin admin = adminServices.authorizeAdmin(client.getLogin(), client.getPassword());
        boolean admin_status = admin != null;
        if (admin_status){
            modelAndView.addObject("admin", admin);
            modelAndView.setViewName("admin_page");
        }
        else{
            Clients authorized_client = clientsServices.authorizeClient(client.getLogin(), client.getPassword());
            Cars car = carsServices.findById(id);
            modelAndView.addObject("car", car);
            boolean status = authorized_client != null;
            if (status) {
                Date date = java.sql.Date.valueOf(LocalDate.now());
                Orders order = new Orders(car,authorized_client,true, date,"new");
                modelAndView.addObject("sign_in_again", false);
                modelAndView.addObject("order", order);
                modelAndView.addObject("client", authorized_client);
                modelAndView.setViewName("order_create");
            }
            else {
                modelAndView.addObject("sign_in_again", true);
                modelAndView.addObject("start_page", false);
                modelAndView.setViewName("sign_in");
            }
        }
        return modelAndView;
    }
}
