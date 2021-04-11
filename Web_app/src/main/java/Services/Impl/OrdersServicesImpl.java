package Services.Impl;

import Classes.Cars;
import Classes.Orders;

import Dao.Impl.OrdersDaoImpl;

import Dao.OrdersDao;

import Services.OrdersServices;

import java.sql.Date;
import java.util.List;

public class OrdersServicesImpl implements OrdersServices {
    OrdersDao ordersDao = new OrdersDaoImpl();

    @Override
    public void save(Orders order) {
        ordersDao.save(order);
    }

    @Override
    public void delete(Orders order) {
        ordersDao.delete(order);
    }

    @Override
    public void changeStatus(Orders order, String status) {
        order.setStatus(status);
        ordersDao.changeStatus(order);
    }

    @Override
    public Orders findOrderById(int id) {
        return ordersDao.findOrderById(id);
    }

    @Override
    public Cars findCarById(int id) {
        return ordersDao.findCarById(id);
    }

    @Override
    public List<Orders> findOrdersByOrderNot(boolean test_drive, Date date_of_order, String status) {
        return ordersDao.findOrdersByOrderNot(test_drive, date_of_order, status);
    }
}
