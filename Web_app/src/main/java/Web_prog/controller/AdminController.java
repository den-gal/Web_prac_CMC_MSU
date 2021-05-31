package Web_prog.controller;

import Classes.*;
import Services.CarsServices;
import Services.Impl.CarsServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private final CarsServices carsServices = new CarsServicesImpl();

    @RequestMapping(value = "/admin_page", method = RequestMethod.GET)
    public ModelAndView admin_page() {
        ModelAndView modelAndView = new ModelAndView();
        Admin admin = new Admin();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("admin_page");
        return modelAndView;
    }

    @RequestMapping(value = "/special_page", method = RequestMethod.GET)
    public ModelAndView special_page(@ModelAttribute("admin")Admin admin) {
        ModelAndView modelAndView = new ModelAndView();
        if (admin.getFunction() == 1)
            admin.setFunction_1(1);
        if (admin.getFunction() == 2)
            admin.setFunction_1(1);
        if (admin.getFunction() == 3)
            admin.setFunction_1(1);
        if (admin.getFunction() == 4)
            admin.setFunction_1(1);
        if (admin.getFunction() == 5)
            admin.setFunction_1(2);
        if (admin.getFunction() == 6)
            admin.setFunction_1(3);
        if (admin.getFunction() == 7)
            admin.setFunction_1(2);
        if (admin.getFunction() == 8)
            admin.setFunction_1(8);
        if (admin.getFunction() == 9)
            admin.setFunction_1(3);
        Cars car = new Cars();
        Clients client = new Clients();
        Orders order = new Orders();
        Form form = carsServices.searchDB();
        modelAndView.addObject("form",form);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("car", car);
        modelAndView.addObject("client", client);
        modelAndView.addObject("order", order);
        modelAndView.setViewName("special_page");
        return modelAndView;
    }
}
