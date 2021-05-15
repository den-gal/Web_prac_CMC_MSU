package Services;

import Classes.Cars;
import Classes.Clients;
import Classes.Form;
import Classes.Orders;

import java.util.List;

public interface CarsServices {
    void save(Cars car);
    void delete(Cars car);

    Cars findById(int id);
    Orders findOrderByCarId(int id);

    List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);

    Form searchDB();

    void changeCarByCarNot(Cars car, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);
    void changeCarsByCarNot(List<Cars> cars, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);

    void deleteCars(String brand);

    void addClientToCar(Cars car, Clients client);

}
