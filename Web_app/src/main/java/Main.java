import Classes.Orders;
import Classes.Cars;
import Classes.Clients;
import Services.CarsServices;
import Services.Impl.CarsServicesImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        CarsServices carsServices = new CarsServicesImpl();
        Cars cars = new Cars();
    }
}
