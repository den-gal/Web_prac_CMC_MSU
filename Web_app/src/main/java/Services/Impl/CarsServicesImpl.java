package Services.Impl;

import Classes.Cars;
import Classes.Clients;
import Classes.Form;
import Classes.Orders;

import Dao.CarsDao;
import Dao.Impl.CarsDaoImpl;

import Services.CarsServices;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarsServicesImpl implements CarsServices {
    CarsDao carsDao = new CarsDaoImpl();
    @Override
    public void save(Cars car) {
        carsDao.save(car);
    }

    @Override
    public void delete(Cars car) {
        carsDao.delete(car);
    }

    @Override
    public Cars findById(int id) {
        return carsDao.findById(id);
    }

    @Override
    public Orders findOrderByCarId(int id) {
        return carsDao.findOrderByCarId(id);
    }

    @Override
    public List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        return carsDao.findCarsByCarNot(brand, manufacturer, technical_not, addition_devices, costumer_not, mutable_not);
    }

    @Override
    public Form searchDB(){
        Form form = new Form();
        List<Cars> cars = carsDao.searchDB();
        form.addBrand(null);
        form.addManufacturers(null);
        form.addTechnical_notifications(null);
        form.addAdditions_devices(null);
        form.addCostumer_notifications(null);
        form.addMutable_notifications(null);
        for (Cars car : cars){
            form.addBrand(car.getBrand());
            form.addManufacturers(car.getManufacturer());
            form.addTechnical_notifications(car.getTechnical_not());
            form.addAdditions_devices(car.getAddition_devices());
            form.addCostumer_notifications(car.getCostumer_not());
            form.addMutable_notifications(car.getMutable_not());
        }
        return form;
    };

    @Override
    public void changeCarByCarNot(Cars car, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        if(brand != null)
            car.setBrand(brand);
        if (manufacturer != null)
            car.setManufacturer(manufacturer);
        if (technical_not != null)
            car.setTechnical_not(technical_not);
        if (addition_devices != null)
            car.setAddition_devices(addition_devices);
        if (costumer_not != null)
            car.setCostumer_not(costumer_not);
        if (mutable_not != null)
            car.setMutable_not(mutable_not);
        carsDao.changeCarByCarNot(car);
    }

    @Override
    public void changeCarsByCarNot(List<Cars> cars, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        if(brand != null)
            for (Cars car : cars) {
                car.setBrand(brand);
            }
        if (manufacturer != null)
            for (Cars car : cars) {
                car.setManufacturer(manufacturer);
            }
        if (technical_not != null)
            for (Cars car : cars) {
                car.setTechnical_not(technical_not);
            }
        if (addition_devices != null)
            for (Cars car : cars) {
                car.setAddition_devices(addition_devices);
            }
        if (costumer_not != null)
            for (Cars car : cars) {
                car.setCostumer_not(costumer_not);
            }
        if (mutable_not != null)
            for (Cars car : cars) {
                car.setMutable_not(mutable_not);
            }
        carsDao.changeCarsByCarNot(cars);
    }

    @Override
    public void deleteCars( String brand) {
        List<Cars> cars = carsDao.findCarsByCarNot(brand, null, null, null, null, null);
        carsDao.deleteCars(cars);
    }

    @Override
    public void addClientToCar(Cars car, Clients client) {
        car.addClient_id(client);
        carsDao.changeCarByCarNot(car);
    }
}
