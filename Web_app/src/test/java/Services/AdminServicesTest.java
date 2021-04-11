package Services;

import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import Services.Impl.AdminServicesImpl;
import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;

import java.util.*;

import junit.framework.TestCase;
import org.junit.Test;
import org.testng.Assert;

public class AdminServicesTest extends TestCase {
    @Test
    public void testSaveAdmin() {
        AdminServices adminServices = new AdminServicesImpl();

        Admin new_admin = new Admin("Admin001", "qwertyAd001232");
        adminServices.save(new_admin);

        Admin admin_check = adminServices.authorizeAdmin("Admin001", "qwertyAd001232");
        Assert.assertEquals(new_admin, admin_check);

       adminServices.delete(new_admin);
    }

    @Test
    public void testDeleteAdmin() {
        AdminServices adminServices = new AdminServicesImpl();

        Admin new_admin = new Admin("Admin001", "qwertyAd001232");
        adminServices.save(new_admin);

        Admin admin_check = adminServices.authorizeAdmin("Admin001", "qwertyAd001232");
        Assert.assertEquals(admin_check.getAdmin_id(), new_admin.getAdmin_id());

        adminServices.delete(new_admin);
    }

    @Test
    public void testFindOrderByOrderIdAdmin() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        Orders order_check = adminServices.findOrderByOrderId(new_order.getOrder_id());
        Assert.assertEquals(new_order, order_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testFindOrderByCarId() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        Orders order_check = adminServices.findOrderByCarId(new_car.getReg_id());
        Assert.assertEquals(new_order, order_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testFindClientById () {
        AdminServices adminServices = new AdminServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Clients client_check = adminServices.findClientById(new_client.getClient_id());
        Assert.assertEquals(new_client, client_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testFindOrdersByClientId () {
        AdminServices adminServices = new AdminServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders(new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);
        clientsServices.addOrderToClient(new_client, new_order);

        List<Orders> order_check = adminServices.findOrdersByClientId(new_client.getClient_id());
        for (Orders order : order_check)
            Assert.assertEquals(new_order, order);

        clientsServices.delete(new_client);
    }

    @Test
    public void testFindClientsByOrderNot () {
        AdminServices adminServices = new AdminServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders(new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        new_client.addOrder(new_order);

        List<Clients> client_check = adminServices.findClientsByOrderNot(true, java.sql.Date.valueOf("2020-02-17"), "new" );
        for (Clients client : client_check)
            Assert.assertEquals(new_client, client);

        clientsServices.delete(new_client);
    }

    @Test
    public void testFindCarsByCarNot () {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        List<Cars> car_check = adminServices.findCarsByCarNot("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None");
        Assert.assertEquals(new_car, car_check.get(0));

        carsServices.delete(new_car);
    }

    @Test
    public void testAuthorizeAdmin () {
        AdminServices adminServices = new AdminServicesImpl();

        Admin new_admin = new Admin("Admin001", "qwertyAd001232");
        adminServices.save(new_admin);

        Admin new_admin1 = new Admin("Admin002", "qwertyAd001233");
        adminServices.save(new_admin1);

        Admin admin_check = adminServices.authorizeAdmin("Admin001", "qwertyAd001232");
        Assert.assertEquals(new_admin, admin_check);

        adminServices.delete(new_admin);
        adminServices.delete(new_admin1);
    }

    @Test
    public void testSaveOrder () {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        adminServices.saveOrder(new_order);

        Orders order_check = adminServices.findOrderByOrderId(new_order.getOrder_id());
        Assert.assertEquals(new_order, order_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testDeleteOrder () {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();
        OrdersServices ordersServices = new OrdersServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2008", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

       adminServices.deleteOrder(new_order);
        Orders order_check = ordersServices.findOrderById(new_order.getOrder_id());
        Assert.assertNull(order_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testChangeOrder () {
        AdminServices adminServices = new AdminServicesImpl();
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
        adminServices.changeOrder(new_order, "processed");

        Orders order_check = ordersServices.findOrderById(new_order.getOrder_id());
        String new_status = order_check.getStatus();
        Assert.assertNotEquals(old_status, new_status);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testSaveClient () {
        AdminServices adminServices = new AdminServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2002", "qwerty2021", "newcomer");
        adminServices.saveClient(new_client);

        Clients client_check = clientsServices.findById(new_client.getClient_id());
        Assert.assertEquals(new_client, client_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testDeleteClient () {
        AdminServices adminServices = new AdminServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

       adminServices.deleteClient(new_client);
        Clients client_check = clientsServices.findById(new_client.getClient_id());
        Assert.assertNull(client_check);
    }

    @Test
    public void testChangeClient () {
        AdminServices adminServices = new AdminServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", "Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        String old_status = new_client.getCostumer_status();
        adminServices.upgradeClient(new_client, null, null, null, null, "beginner");
        Clients client_check = clientsServices.findById(new_client.getClient_id());
        String new_status = client_check.getCostumer_status();
        Assert.assertNotEquals(old_status, new_status);

        clientsServices.delete(new_client);
    }

    @Test
    public void testSaveCar() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        adminServices.saveCar(new_car);

        Cars car_check = carsServices.findById(new_car.getReg_id());
        Assert.assertEquals(new_car, car_check);

        carsServices.delete(new_car);
    }

    @Test
    public void testDeleteCar() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();
        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        adminServices.deleteCar(new_car);
        Cars cars_check = carsServices.findById(new_car.getReg_id());
        Assert.assertNull(cars_check);
    }

    @Test
    public void testChangeCar() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        String old_brand = new_car.getBrand();
        adminServices.upgradeCar(new_car, "Mercedes", null,null,null,null,null);
        Cars car_check = carsServices.findById(new_car.getReg_id());
        String new_brand = car_check.getBrand();
        Assert.assertNotEquals(new_brand, old_brand);

        carsServices.delete(new_car);
    }

    @Test
    public void testDeleteCars() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car1 = new Cars("BMWs", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car1);

        Cars new_car2 = new Cars("BMWs", "China", "V8", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car2);

        adminServices.deleteCars( "BMWs");
        Cars cars_check = carsServices.findById(new_car1.getReg_id());
        Assert.assertNull(cars_check);
    }

    @Test
    public void testChangeCars() {
        AdminServices adminServices = new AdminServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);
        Cars new_car1 = new Cars("BMW", "USA", "V8", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car1);

        String old_brand = new_car.getBrand();
        List<Cars> cars = carsServices.findCarsByCarNot("BMW", null, null, null, null, null);
        adminServices.upgradeCars(cars, "Mercedes", null,null,null,null,null);

        String new_brand = carsServices.findById(new_car.getReg_id()).getBrand();
        Assert.assertNotEquals(new_brand, old_brand);

        carsServices.delete(new_car);
        carsServices.delete(new_car1);
    }
}