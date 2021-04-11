package Services.Impl;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import Dao.AdminDao;
import Dao.Impl.AdminDaoImpl;

import Services.AdminServices;
import Services.CarsServices;
import Services.ClientsServices;
import Services.OrdersServices;


import java.sql.Date;
import java.util.List;

public class AdminServicesImpl implements AdminServices {
    OrdersServices ordersServices = new OrdersServicesImpl();
    ClientsServices clientsServices = new ClientsServicesImpl();
    AdminDao adminDao = new AdminDaoImpl();
    CarsServices carsServices = new CarsServicesImpl();

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminDao.delete(admin);
    }

    @Override
    public Orders findOrderByOrderId(int id) {
        return ordersServices.findOrderById(id);
    }

    @Override
    public Orders findOrderByCarId(int id) {
        return carsServices.findOrderByCarId(id);
    }

    @Override
    public Clients findClientById(int id) {
        return clientsServices.findById(id);
    }

    @Override
    public List<Orders> findOrdersByClientId(int id) {
        return clientsServices.findOrdersByClientId(id);
    }

    @Override
    public List<Clients> findClientsByOrderNot(boolean test_drive, Date date_of_order, String status) {
        return clientsServices.findClientsByOrderNot(test_drive, date_of_order, status);
    }

    @Override
    public List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        return carsServices.findCarsByCarNot(brand, manufacturer, technical_not, addition_devices, costumer_not, mutable_not);
    }

    @Override
    public Admin authorizeAdmin(String login, String password) {
        return adminDao.authorizeAdmin(login, password);
    }

    @Override
    public void saveOrder(Orders order) {
        ordersServices.save(order);
    }

    @Override
    public void deleteOrder(Orders order) {
        ordersServices.delete(order);
    }

    @Override
    public void changeOrder(Orders order, String status) {
        ordersServices.changeStatus(order, status);
    }

    @Override
    public void saveClient(Clients client) {
        clientsServices.save(client);
    }

    @Override
    public void deleteClient(Clients client) {
        clientsServices.delete(client);
    }

    @Override
    public void upgradeClient(Clients client, String full_name, String client_inf, String login, String password, String costumer_status) {
        clientsServices.changeClient(client, full_name, client_inf, login, password, costumer_status);
    }

    @Override
    public void saveCar(Cars car) {
        carsServices.save(car);
    }

    @Override
    public void deleteCar(Cars car) {
        carsServices.delete(car);
    }

    @Override
    public void upgradeCar(Cars car, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        carsServices.changeCarByCarNot(car, brand, manufacturer, technical_not, addition_devices, costumer_not, mutable_not);
    }

    @Override
    public void deleteCars( String brand) {
        carsServices.deleteCars( brand);
    }

    @Override
    public void upgradeCars(List<Cars> cars, String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        carsServices.changeCarsByCarNot(cars, brand, manufacturer, technical_not, addition_devices, costumer_not, mutable_not);
    }
}
