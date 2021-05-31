package Web_prog.controller;

import Classes.Cars;
import Classes.Clients;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.CarsServicesImpl;

import Services.Impl.ClientsServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Confirm_formController {
    private final CarsServices carsServices = new CarsServicesImpl();
    private final ClientsServices clientsServices = new ClientsServicesImpl();

    @RequestMapping(value = "/confirm_form", method = RequestMethod.GET)
    public ModelAndView allCars(@ModelAttribute("car_inf")Cars car) {
        ModelAndView modelAndView = new ModelAndView();
        if (car.getBrand().equals("")) {
            car.setBrand(null);
        }
        if (car.getManufacturer().equals("")) {
            car.setManufacturer(null);
        }
        if (car.getTechnical_not().equals("")) {
            car.setTechnical_not(null);
        }
        if (car.getAddition_devices().equals("")) {
            car.setAddition_devices(null);
        }
        if (car.getCostumer_not().equals("")) {
            car.setCostumer_not(null);
        }
        if (car.getMutable_not().equals("")) {
            car.setMutable_not(null);
        }
        Clients client = new Clients();
        client.setLogin(null);
        modelAndView.addObject("client", client);
        List<Cars> cars = carsServices.findCarsByCarNot(car.getBrand(), car.getManufacturer(), car.getTechnical_not(), car.getAddition_devices(), car.getCostumer_not(), car.getMutable_not());
        modelAndView.setViewName("confirm_form");
        modelAndView.addObject("carsList", cars);
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in/confirm_form/{client_id}", method = RequestMethod.GET)
    public ModelAndView sign_in_allCars(@ModelAttribute("car_inf") Cars car, @PathVariable("client_id") int client_id){
        ModelAndView modelAndView = new ModelAndView();
        if (car.getBrand().equals("")) {
            car.setBrand(null);
        }
        if (car.getManufacturer().equals("")) {
            car.setManufacturer(null);
        }
        if (car.getTechnical_not().equals("")) {
            car.setTechnical_not(null);
        }
        if (car.getAddition_devices().equals("")) {
            car.setAddition_devices(null);
        }
        if (car.getCostumer_not().equals("")) {
            car.setCostumer_not(null);
        }
        if (car.getMutable_not().equals("")) {
            car.setMutable_not(null);
        }
        List<Cars> cars = carsServices.findCarsByCarNot(car.getBrand(), car.getManufacturer(), car.getTechnical_not(), car.getAddition_devices(), car.getCostumer_not(), car.getMutable_not());
        Clients client = clientsServices.findById(client_id);
        modelAndView.setViewName("confirm_form");
        modelAndView.addObject("carsList", cars);
        modelAndView.addObject("client", client);
        return modelAndView;
    }
}
