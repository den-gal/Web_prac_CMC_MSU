package Services;

import Classes.Cars;
import Classes.Orders;

import java.util.List;

public interface OrdersServices {
    void save(Orders order);
    void delete(Orders order);
    void changeStatus(Orders order, String status);

    Orders findOrderById(int id);
    Cars findCarById(int id);
    List<Orders> findOrdersByOrderNot(boolean test_drive, java.sql.Date date_of_order, String status);
}
