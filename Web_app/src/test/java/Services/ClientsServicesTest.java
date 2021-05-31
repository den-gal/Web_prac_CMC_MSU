package Services;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;

import junit.framework.TestCase;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;

public class ClientsServicesTest extends TestCase {
    @Test
    public void testSaveClient() {
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", "89232322332", "Joe_Brainstorm_2010", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Clients client_check = clientsServices.findById(new_client.getClient_id());
        Assert.assertEquals(new_client, client_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testDeleteClient() {
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        clientsServices.delete(new_client);
        Clients client_check = clientsServices.findById(new_client.getClient_id());
        Assert.assertNull(client_check);
    }

    @Test
    public void testFindClientById () {
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Clients client_check = clientsServices.findById(new_client.getClient_id());
        Assert.assertEquals(new_client, client_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testAuthorizeClient () {
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", "Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Clients client_check = clientsServices.authorizeClient("Joe_Brainstorm_2001", "qwerty2021");
        Assert.assertEquals(new_client, client_check);

        clientsServices.delete(new_client);
    }

    @Test
    public void testFindOrderByClientId () {
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

        List<Orders> order_check = clientsServices.findOrdersByClientId(new_client.getClient_id());
        for (Orders order : order_check)
            Assert.assertEquals(new_order, order);

        clientsServices.delete(new_client);
    }

    @Test
    public void testFindClientsByOrderNot () {
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

        List<Clients> client_check = clientsServices.findClientsByOrderNot(true, java.sql.Date.valueOf("2020-02-17"), "new" );
        for (Clients client : client_check)
            Assert.assertEquals(new_client, client);

        clientsServices.delete(new_client);
    }

    @Test
    public void testFindCarsByCarNot () {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        List<Cars> cars_check = clientsServices.findCarsByCarNot("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None");
        for (Cars car : cars_check){
            Assert.assertEquals(new_car, car);
        }

        clientsServices.delete(new_client);
        carsServices.delete(new_car);
    }

    @Test
    public void testChangeClient() {
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", "Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        String old_status = new_client.getCostumer_status();
        clientsServices.changeClient(new_client, null, null, null, null, "beginner");
        Clients client_check = clientsServices.findById(new_client.getClient_id());
        String new_status = client_check.getCostumer_status();
        Assert.assertNotEquals(old_status, new_status);

        clientsServices.delete(new_client);
    }

    @Test
    public void testAddOrderToClient () {
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

        for (Orders order : new_client.getOrders())
            Assert.assertEquals(new_order, order);

        clientsServices.delete(new_client);
    }
}