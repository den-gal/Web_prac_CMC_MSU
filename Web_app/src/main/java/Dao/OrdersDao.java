package Dao;

import Classes.Orders;
import Classes.Cars;

import java.util.List;

public interface OrdersDao {
    void save(Orders order);
    void delete(Orders order);
    void changeStatus(Orders order);

    Orders findOrderById(int id);
    Cars findCarById(int id);
    List<Orders> findOrdersByOrderNot( boolean test_drive, java.sql.Date date_of_order, String status);
}
