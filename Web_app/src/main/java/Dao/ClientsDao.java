package Dao;

import Classes.Orders;
import Classes.Clients;

import java.util.List;

public interface ClientsDao {
    void save(Clients client);
    void delete(Clients client);

    Clients findById(int id);
    Clients authorizeClient(String login, String password);

    List<Orders> findOrdersByClientId(int id);
    List<Clients> findClientsByOrderNot(List<Orders> orders);

    void changeClient(Clients client);
}
