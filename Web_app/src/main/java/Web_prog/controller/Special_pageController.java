package Web_prog.controller;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;
import Services.AdminServices;
import Services.Impl.AdminServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Special_pageController {
    private final AdminServices adminServices = new AdminServicesImpl();

    @RequestMapping(value = "/special_page_2/1", method = RequestMethod.GET)
    public ModelAndView special_page_2_1(@ModelAttribute("admin") Admin admin) {
        int id = admin.getNumber();
        ModelAndView modelAndView = new ModelAndView();
        Orders order = adminServices.findOrderByOrderId(id);
        modelAndView.addObject("number", 1);
        modelAndView.addObject("order", order);
        modelAndView.setViewName("special_page_2");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_2/2", method = RequestMethod.GET)
    public ModelAndView special_page_2_2(@ModelAttribute("admin") Admin admin) {
        int id = admin.getNumber();
        ModelAndView modelAndView = new ModelAndView();
        Orders order = adminServices.findOrderByCarId(id);
        modelAndView.addObject("number", 1);
        modelAndView.addObject("order", order);
        modelAndView.setViewName("special_page_2");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_2/3", method = RequestMethod.GET)
    public ModelAndView special_page_2_3(@ModelAttribute("admin") Admin admin) {
        int id = admin.getNumber();
        ModelAndView modelAndView = new ModelAndView();
        Clients client = adminServices.findClientById(id);
        modelAndView.addObject("number", 2);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("special_page_2");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_2/4", method = RequestMethod.GET)
    public ModelAndView special_page_2_4(@ModelAttribute("admin") Admin admin) {
        int id = admin.getNumber();
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orders = adminServices.findOrdersByClientId(id);
        modelAndView.addObject("number", 3);
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("special_page_2");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_2/5", method = RequestMethod.GET)
    public ModelAndView special_page_2_5(@ModelAttribute("order") Orders order) {
        ModelAndView modelAndView = new ModelAndView();
        List<Clients> clients = adminServices.findClientsByOrderNot(order.isTest_drive(),order.getDate_of_order(),order.getStatus());
        modelAndView.addObject("number", 4);
        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("special_page_2");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_2/6", method = RequestMethod.GET)
    public ModelAndView special_page_2_6(@ModelAttribute("car") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.saveCar(car);
        List<Cars> cars = adminServices.findCarsByCarNot(car.getBrand(), car.getManufacturer(), car.getTechnical_not(), car.getAddition_devices(), car.getCostumer_not(), car.getMutable_not());
        modelAndView.addObject("number", 5);
        modelAndView.addObject("cars", cars);
        modelAndView.setViewName("special_page_2");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_2/7", method = RequestMethod.GET)
    public ModelAndView special_page_2_7(@ModelAttribute("order") Orders order) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.saveOrder(order);
        Admin admin = new Admin();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("admin_page");
        return modelAndView;
    }
    @RequestMapping(value = "/special_page_2/8", method = RequestMethod.GET)
    public ModelAndView special_page_2_8(@ModelAttribute("client") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.saveClient(client);
        Admin admin = new Admin();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("admin_page");
        return modelAndView;
    }
    @RequestMapping(value = "/special_page_2/9", method = RequestMethod.GET)
    public ModelAndView special_page_2_9(@ModelAttribute("car") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.saveCar(car);
        Admin admin = new Admin();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("admin_page");
        return modelAndView;
    }
}
