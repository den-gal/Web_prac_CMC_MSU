package Dao.Impl;

import Classes.Cars;
import Classes.Orders;
import Dao.OrdersDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.query.Query;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao{
    @Override
    public void save(Orders order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(order);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("OrdersSave exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void delete(Orders order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(order);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("OrdersDelete exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void changeStatus(Orders order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(order);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("OrdersChangeStatus exception thrown: " + e.getMessage());
        }
    }

    @Override
    public Orders findOrderById(int id) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Orders order = session.get(Orders.class, id);
            session.close();
            System.out.println(order.getOrder_id());
            return order;
        }
        catch (Exception e){
            System.out.println("OrdersFindById exception thrown: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Cars findCarById(int id) {
        try {
            Orders order = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Orders.class, id);
            Cars car = order.getCar_id();
            return car;
        }
        catch (Exception e){
            System.out.println("OrdersFindCarById exception thrown: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Orders> findOrdersByOrderNot( boolean test_drive, java.sql.Date date_of_order, String status) {
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            List<Orders> orders = null;
            if(test_drive){
                if(date_of_order != null){
                    Query<Orders> query;
                    if (status != null){
                        query = session.createQuery("From Orders WHERE (test_drive = true) and (date_of_order = :param) and (status = :param1)").setParameter("param", date_of_order).setParameter("param1", status);
                    }
                    else{
                        query = session.createQuery("From Orders WHERE (test_drive = true) and (date_of_order = :param)").setParameter("param", date_of_order);
                    }
                    orders = query.getResultList();
                }
                else if (status != null){
                    Query<Orders> query = session.createQuery("From Orders WHERE (test_drive = true) and (status = :param)").setParameter("param",status);
                    orders = query.getResultList();
                }
                else
                {
                    Query<Orders> query = session.createQuery("From Orders WHERE test_drive = true ");
                    orders = query.getResultList();
                }
            }
            else if(date_of_order != null){
                Query<Orders> query;
                if (status != null){
                    query = session.createQuery("From Orders WHERE (date_of_order = :param) and (status = :param1)").setParameter("param", date_of_order).setParameter("param1", status);
                }
                else{
                    query = session.createQuery("From Orders WHERE date_of_order = :param").setParameter("param", date_of_order);
                }
                orders = query.getResultList();
            }
            else if(status != null){
                Query<Orders> query = session.createQuery("From Orders WHERE status = :param").setParameter("param",status);
                orders = query.getResultList();
            }
            else{
                System.out.println("Warning :: FindOrdersByOrderNot has empty attributes");
            }
            return orders;
        }
        catch (Exception e){
            System.out.println("OrdersFindCarById exception thrown: " + e.getMessage());
            return null;
        }
    }
}
