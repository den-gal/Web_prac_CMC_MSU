package Services;

import Classes.Cars;
import Classes.Clients;
import Classes.Orders;

import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;

import java.util.*;

import junit.framework.TestCase;
import org.junit.Test;
import org.testng.Assert;

public class CarsServicesTest extends TestCase {

    @Test
    public void testSaveCar() {
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Cars car_check = carsServices.findById(new_car.getReg_id());
        Assert.assertEquals(new_car, car_check);

        carsServices.delete(new_car);
    }

    @Test
    public void testDeleteCar() {
        CarsServices carsServices = new CarsServicesImpl();
        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        carsServices.delete(new_car);
        Cars cars_check = carsServices.findById(new_car.getReg_id());
        Assert.assertNull(cars_check);
    }

    @Test
    public void testFindCarById () {
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Cars car_check = carsServices.findById(new_car.getReg_id());
        Assert.assertEquals(new_car, car_check);

        carsServices.delete(new_car);
    }

    @Test
    public void testFindOrderByCarId () {
        OrdersServices ordersServices = new OrdersServicesImpl();
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        Orders new_order = new Orders( new_car, new_client,true,  java.sql.Date.valueOf("2020-02-17"), "new");
        ordersServices.save(new_order);

        Orders order_check = carsServices.findOrderByCarId(new_car.getReg_id());
        Assert.assertEquals(new_order, order_check);

        ordersServices.delete(new_order);
        clientsServices.delete(new_client);
    }

    @Test
    public void testFindCarsByCarNot () {
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        List<Cars> car_check = carsServices.findCarsByCarNot("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None");
        Assert.assertEquals(new_car, car_check.get(0));

        carsServices.delete(new_car);
    }

    @Test
    public void testChangeCarByCarNot () {
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        String old_brand = new_car.getBrand();
        carsServices.changeCarByCarNot(new_car, "Mercedes", null,null,null,null,null);
        Cars car_check = carsServices.findById(new_car.getReg_id());
        String new_brand = car_check.getBrand();
        Assert.assertNotEquals(new_brand, old_brand);

        carsServices.delete(new_car);
    }

    @Test
    public void testChangeCarsByCarNot () {
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car = new Cars("BMW", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);
        Cars new_car1 = new Cars("BMW", "USA", "V8", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car1);

        String old_brand = new_car.getBrand();
        List<Cars> cars = carsServices.findCarsByCarNot("BMW", null, null, null, null, null);
        carsServices.changeCarsByCarNot(cars, "Mercedes", null,null,null,null,null);

        String new_brand = carsServices.findById(new_car.getReg_id()).getBrand();
        Assert.assertNotEquals(new_brand, old_brand);

        carsServices.delete(new_car);
        carsServices.delete(new_car1);
    }

    @Test
    public void testDeleteCars() {
        CarsServices carsServices = new CarsServicesImpl();

        Cars new_car1 = new Cars("BMWs", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car1);

        Cars new_car2 = new Cars("BMWs", "China", "V8", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car2);

        carsServices.deleteCars( "BMWs");
        Cars cars_check = carsServices.findById(new_car1.getReg_id());
        Assert.assertNull(cars_check);
    }

    @Test
    public void testAddClientToCar () {
        CarsServices carsServices = new CarsServicesImpl();
        ClientsServices clientsServices = new ClientsServicesImpl();

        Clients new_client = new Clients("Joe Brainstorm", " 89232322332", " Joe_Brainstorm_2001", "qwerty2021", "newcomer");
        clientsServices.save(new_client);

        Cars new_car = new Cars("BMWs", "China", "V6", "GPS, CrCon", " Red, leather", "None", 1212323);
        carsServices.save(new_car);

        carsServices.addClientToCar(new_car, new_client);

        for (Clients client : new_car.getClients_id())
        {
            Assert.assertEquals(new_client, client);
        }
        carsServices.delete(new_car);
    }

}