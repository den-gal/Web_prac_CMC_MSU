package Web_prog.controller;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;
import Services.AdminServices;
import Services.CarsServices;
import Services.Impl.AdminServicesImpl;
import Services.Impl.CarsServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Special_page_3Controller {
    private final AdminServices adminServices = new AdminServicesImpl();
    private final CarsServices carsServices =  new CarsServicesImpl();

    @RequestMapping(value = "/special_page_3/1/1", method = RequestMethod.GET)
    public ModelAndView special_page_3_1_1(@ModelAttribute("order") Orders order) {
        ModelAndView modelAndView = new ModelAndView();
        Orders order_inf = new Orders();
        Admin admin = new Admin();
        admin.setNumber(1);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("order_inf", order_inf);
        modelAndView.setViewName("special_page_3");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/1/1/{id}", method = RequestMethod.POST)
    public ModelAndView special_page_3_1_1_post(@ModelAttribute("order_inf") Orders order_inf, @PathVariable("id") int id) {
        Orders order = adminServices.findOrderByOrderId(id);
        ModelAndView modelAndView = new ModelAndView();
        if (order_inf.getStatus().equals(""))
            order_inf.setStatus(null);
        adminServices.changeOrder(order, order_inf.getStatus());
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }
    @RequestMapping(value = "/special_page_3/1/2", method = RequestMethod.POST)
    public ModelAndView special_page_3_1_2(@ModelAttribute("order") Orders order) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.deleteOrder(order);
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/2/1", method = RequestMethod.GET)
    public ModelAndView special_page_3_2_1(@ModelAttribute("client") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        Clients client_inf = new Clients();
        Admin admin = new Admin();
        admin.setNumber(2);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("client_inf", client_inf);
        modelAndView.setViewName("special_page_3");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/2/1/{id}", method = RequestMethod.POST)
    public ModelAndView special_page_3_2_1_post(@ModelAttribute("client_inf") Clients client_inf, @PathVariable("id") int id) {
        Clients client = adminServices.findClientById(id);
        ModelAndView modelAndView = new ModelAndView();
        if (client_inf.getFull_name().equals(""))
            client_inf.setFull_name(null);
        if (client_inf.getClient_inf().equals(""))
            client_inf.setClient_inf(null);
        if (client_inf.getLogin().equals(""))
            client_inf.setLogin(null);
        if (client_inf.getCostumer_status().equals(""))
            client_inf.setCostumer_status(null);
        adminServices.upgradeClient(client, client_inf.getFull_name(), client_inf.getClient_inf(), client_inf.getLogin(),client_inf.getPassword(),client_inf.getCostumer_status());
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }
    @RequestMapping(value = "/special_page_3/2/2/{id}", method = RequestMethod.POST)
    public ModelAndView special_page_3_2_2(@ModelAttribute("client") Clients client, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        client = adminServices.findClientById(id);
        adminServices.deleteClient(client);
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/5/1", method = RequestMethod.GET)
    public ModelAndView special_page_3_5_1(@ModelAttribute("car") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        Cars car_inf = new Cars();
        Admin admin = new Admin();
        admin.setNumber(5);
        admin.setFunction(1);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("car_inf", car_inf);
        modelAndView.setViewName("special_page_3");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/5/1/{id}", method = RequestMethod.POST)
    public ModelAndView special_page_3_5_1_post(@ModelAttribute("car_inf") Cars car_inf, @PathVariable("id") int id) {
        Cars car = carsServices.findById(id);
        if (car_inf.getBrand().equals("")) {
            car_inf.setBrand(null);
        }
        if (car_inf.getManufacturer().equals("")) {
            car_inf.setManufacturer(null);
        }
        if (car_inf.getTechnical_not().equals("")) {
            car_inf.setTechnical_not(null);
        }
        if (car_inf.getAddition_devices().equals("")) {
            car_inf.setAddition_devices(null);
        }
        if (car_inf.getCostumer_not().equals("")) {
            car_inf.setCostumer_not(null);
        }
        if (car_inf.getMutable_not().equals("")) {
            car_inf.setMutable_not(null);
        }
        ModelAndView modelAndView = new ModelAndView();
        adminServices.upgradeCar(car, car_inf.getBrand(), car_inf.getManufacturer(), car_inf.getTechnical_not(), car_inf.getAddition_devices(), car_inf.getCostumer_not(), car_inf.getMutable_not());
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }
    @RequestMapping(value = "/special_page_3/5/2", method = RequestMethod.POST)
    public ModelAndView special_page_3_5_2(@ModelAttribute("car") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.deleteCar(car);
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/6/1", method = RequestMethod.GET)
    public ModelAndView special_page_3_6_1(@ModelAttribute("car") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        Cars car_inf = new Cars();
        Admin admin = new Admin();
        admin.setFunction(2);
        admin.setNumber(5);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("car_inf", car_inf);
        modelAndView.setViewName("special_page_3");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page_3/6/1/{id}", method = RequestMethod.POST)
    public ModelAndView special_page_3_6_1_post(@ModelAttribute("car_inf") Cars car_inf, @PathVariable("id") int id) {
        Cars car = carsServices.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        if (car_inf.getBrand().equals("")) {
            car_inf.setBrand(null);
        }
        if (car_inf.getManufacturer().equals("")) {
            car_inf.setManufacturer(null);
        }
        if (car_inf.getTechnical_not().equals("")) {
            car_inf.setTechnical_not(null);
        }
        if (car_inf.getAddition_devices().equals("")) {
            car_inf.setAddition_devices(null);
        }
        if (car_inf.getCostumer_not().equals("")) {
            car_inf.setCostumer_not(null);
        }
        if (car_inf.getMutable_not().equals("")) {
            car_inf.setMutable_not(null);
        }
        List<Cars> cars = adminServices.findCarsByCarNot(car.getBrand(), car.getManufacturer(), car.getTechnical_not(), car.getAddition_devices(), car.getCostumer_not(), car.getMutable_not());
        adminServices.deleteCar(car);
        adminServices.upgradeCars(cars, car_inf.getBrand(), car_inf.getManufacturer(), car_inf.getTechnical_not(), car_inf.getAddition_devices(), car_inf.getCostumer_not(), car_inf.getMutable_not());
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }
    @RequestMapping(value = "/special_page_3/6/2", method = RequestMethod.POST)
    public ModelAndView special_page_3_6_2(@ModelAttribute("car") Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        adminServices.deleteCars(car.getBrand());
        modelAndView.setViewName("redirect:/admin_page");
        return modelAndView;
    }
}
