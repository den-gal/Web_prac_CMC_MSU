package Services.Impl;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import Dao.ClientsDao;

import Dao.Impl.ClientsDaoImpl;

import Services.ClientsServices;
import Services.CarsServices;
import Services.OrdersServices;

import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientsServicesImpl implements ClientsServices {
    ClientsDao clientsDao = new ClientsDaoImpl();
    OrdersServices ordersServices = new OrdersServicesImpl();
    CarsServices carsServices = new CarsServicesImpl();

    @Override
    public void save(Clients client) {
        clientsDao.save(client);
    }

    @Override
    public void delete(Clients client) {
        clientsDao.delete(client);
    }

    @Override
    public Clients findById(int id) {
        return clientsDao.findById(id);
    }

    @Override
    public Clients authorizeClient(String login, String password) {
        return clientsDao.authorizeClient(login, password);
    }

    @Override
    public List<Orders> findOrdersByClientId(int id) {
        return clientsDao.findOrdersByClientId(id);
    }

    @Override
    public List<Clients> findClientsByOrderNot(boolean test_drive, Date date_of_order, String status) {
        List<Orders> orders = ordersServices.findOrdersByOrderNot(test_drive, date_of_order, status);
        return clientsDao.findClientsByOrderNot(orders);
    }

    @Override
    public List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        return carsServices.findCarsByCarNot(brand, manufacturer, technical_not, addition_devices, costumer_not, mutable_not);
    }

    @Override
    public void changeClient(Clients client, String full_name, String client_inf, String login, String password, String costumer_status) {
        if (full_name != null)
            client.setFull_name(full_name);
        if (client_inf != null)
            client.setClient_inf(client_inf);
        if (login != null)
            client.setLogin(login);
        if (password != null)
            client.setPassword(password);
        if (costumer_status != null)
            client.setCostumer_status(costumer_status);
        clientsDao.changeClient(client);
    }

    @Override
    public void addOrderToClient(Clients client, Orders order) {
        client.addOrder(order);
        clientsDao.addOrderToClient(client, order);
    }
}
