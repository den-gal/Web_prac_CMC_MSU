package Utils;

import Classes.Admin;
import Classes.Orders;
import Classes.Cars;
import Classes.Clients;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Clients.class);
                configuration.addAnnotatedClass(Cars.class);
                configuration.addAnnotatedClass(Orders.class);
                configuration.addAnnotatedClass(Admin.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
            catch (Exception e) {
                System.out.println("Exception from Session: " + e);
            }
        }
        return sessionFactory;
    }
}
