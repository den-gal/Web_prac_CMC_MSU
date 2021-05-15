package Dao;

import Classes.Cars;
import Classes.Clients;
import Classes.Form;
import Classes.Orders;

import java.util.List;

public interface CarsDao {
    void save(Cars car);
    void delete(Cars car);

    Cars findById(int id);
    Orders findOrderByCarId(int id);

    List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);

    List<Cars> searchDB();

    void changeCarByCarNot(Cars car);
    void changeCarsByCarNot(List<Cars> cars);

    void deleteCars(List<Cars> cars);

    void addClientToCar(Cars car, Clients client);
}
