package Services;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import java.util.List;

public interface ClientsServices {
    void save(Clients client);
    void delete(Clients client);

    Clients findById(int id);
    Clients authorizeClient(String login, String password);

    List<Orders> findOrdersByClientId(int id);
    List<Clients> findClientsByOrderNot(boolean testdrive, java.sql.Date date_of_order, String status);
    List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String additin_devices, String costumer_not, String changeble_not);

    void changeClient(Clients client, String full_name, String client_inf, String login, String password, String costumer_status);

    void addOrderToClient(Clients client, Orders order);
}
