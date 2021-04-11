package Dao.Impl;

import Classes.Clients;
import Classes.Orders;
import Dao.ClientsDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ClientsDaoImpl implements ClientsDao {
    @Override
    public void save(Clients client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(client);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("ClientsSave Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void delete(Clients client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(client);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("ClientsDelete exception thrown: " + e.getMessage());
        }
    }

    @Override
    public Clients findById(int id) {
        try {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Clients.class, id);
        }
        catch (Exception e){
            System.out.println("ClientsFindById exception thrown: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Clients authorizeClient(String login, String password) {
        try{
                Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
                Query<Clients> query = session.createQuery("From Clients WHERE login = :param").setParameter("param", login);
                List<Clients> clients = query.getResultList();
            try{
                Clients client = clients.get(0);
                if(client.getPassword().equals(password))
                {
                    return client;
                }
                else{
                    System.out.println("Failed client authorization");
                    return null;
                }
            }
            catch(Exception e){
                System.out.println("ClientsAuthorizeClient with login exception thrown: " + e.getMessage());
                return null;
            }
        }
        catch(Exception ex){
            System.out.println("ClientsAuthorizeClient exception thrown: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Orders> findOrdersByClientId(int id) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Clients client = session.get(Clients.class, id);
            return client.getOrders();
        }
        catch(Exception e){
            System.out.println("ClientsFindOrdersByClientId exception thrown: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Clients> findClientsByOrderNot(List<Orders> orders) {
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query<Clients> query = session.createQuery("From Clients");
            List<Clients> clients1 = query.getResultList();
            List<Clients> clients = new ArrayList<>();
            for (Orders order : orders)
                for (Clients client : clients1)
                    for (Orders order1 : client.getOrders())
                        if(order == order1)
                            clients.add(client);
            return clients;
        }
        catch(Exception e){
            System.out.println("ClientsFindClientsByOrderNot exception thrown: " + e.getMessage());
            return null;
        }
    }


    @Override
    public void changeClient(Clients client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(client);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("ClientsChangeClient exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void addOrderToClient(Clients client, Orders order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(client);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("ClientsAddOrderToClient exception thrown: " + e.getMessage());
        }
    }
}
