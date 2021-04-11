package Services;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import java.util.List;

public interface AdminServices {
    void save(Admin admin);
    void delete(Admin admin);

    Orders findOrderByOrderId(int id);
    Orders findOrderByCarId(int id);
    Clients findClientById(int id);

    List<Orders> findOrdersByClientId(int id);
    List<Clients> findClientsByOrderNot(boolean test_drive, java.sql.Date date_of_order, String status);
    List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);

    Admin authorizeAdmin(String login, String password);

    void saveOrder(Orders order);
    void deleteOrder(Orders order);
    void changeOrder(Orders order, String status);

    void saveClient(Clients client);
    void deleteClient(Clients client);
    void upgradeClient(Clients client, String full_name, String client_inf, String login, String password, String costumer_status);

    void saveCar(Cars car);
    void deleteCar(Cars car);
    void upgradeCar(Cars car, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);

    void deleteCars( String brand);
    void upgradeCars(List<Cars> cars, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not);
}
