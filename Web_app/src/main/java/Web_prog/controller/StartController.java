package Web_prog.controller;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;

import Classes.Form;
import Services.AdminServices;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.AdminServicesImpl;
import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();
    private final AdminServices adminServices = new AdminServicesImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView start_page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start_page");
        Cars car_inf = new Cars();
        Form form = carsServices.searchDB();
        Clients client = new Clients();
        client.setLogin(null);
        modelAndView.addObject("client", client);
        modelAndView.addObject("form", form);
        modelAndView.addObject("car_inf", car_inf);
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/start_page", method = RequestMethod.GET)
    public ModelAndView sign_in_start_page(@ModelAttribute("client_inf") Clients client) {
        ModelAndView modelAndView = new ModelAndView();
        Admin admin = adminServices.authorizeAdmin(client.getLogin(), client.getPassword());
        boolean admin_status = admin != null;
        if (admin_status){
            modelAndView.setViewName("admin_page");
            modelAndView.addObject("admin", admin);
        }
        else {
            Clients authorized_client = clientsServices.authorizeClient(client.getLogin(), client.getPassword());
            boolean status = authorized_client != null;
            if (status) {
                modelAndView.setViewName("start_page");
                Cars car_inf = new Cars();
                Form form = carsServices.searchDB();
                modelAndView.addObject("sign_in_again", false);
                modelAndView.addObject("form", form);
                modelAndView.addObject("car_inf", car_inf);
                modelAndView.addObject("client", authorized_client);
            }
            else {
                Cars car = new Cars();
                car.setBrand(null);
                modelAndView.addObject("car", car);
                modelAndView.addObject("start_page", true);
                modelAndView.addObject("sign_in_again", true);
                modelAndView.setViewName("sign_in");
            }
        }
        return modelAndView;
    }
}
