package Services;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;
import Services.Impl.CarsServicesImpl;

import junit.framework.TestCase;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;


public class OrdersServicesTest extends TestCase {
    @Test
    public void testSaveOrder() {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS,CrCon", "Red,leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("JoeBrainstorm", "89232322332", "Joe_Brainstorm_2009", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        Orders order_check = ordersServices.findOrderById(new_order.getOrder_id());
        Assert.assertEquals(new_order, order_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testDeleteOrder() {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        ordersServices.delete(new_order);
        Orders order_check = ordersServices.findOrderById(new_order.getOrder_id());
        Assert.assertNull(order_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testChangeOrder() {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        String old_status = new_order.getStatus();
        ordersServices.changeStatus(new_order, "processed");

        Orders order_check = ordersServices.findOrderById(new_order.getOrder_id());
        String new_status = order_check.getStatus();
        Assert.assertNotEquals(old_status, new_status);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testFindOrderById () {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        Orders order_check = ordersServices.findOrderById(new_order.getOrder_id());
        Assert.assertEquals(new_order, order_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testFindCarById () {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        Cars car_check = ordersServices.findCarById(new_order.getOrder_id());
        Assert.assertEquals(new_car, car_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testFindOrdersByOrderNot () {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        List<Orders> orders = ordersServices.findOrdersByOrderNot(true, java.sql.Date.valueOf("2020-02-17"), "new");
        Assert.assertEquals(orders.get(0), new_order);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }
}