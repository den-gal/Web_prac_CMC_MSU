package Dao.Impl;

import Classes.Admin;
import Dao.AdminDao;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public void save(Admin admin) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(admin);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("AdminsSave Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void delete(Admin admin) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(admin);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("AdminsDelete exception thrown: " + e.getMessage());
        }
    }

    @Override
    public Admin authorizeAdmin(String login, String password) {
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query<Admin> query = session.createQuery("From Admin WHERE login = :param").setParameter("param", login);
            List<Admin> admins = query.getResultList();
            if (admins == null)
                return null;
            try{
                Admin admin = admins.get(0);
                if(admin.getPassword().equals(password))
                {
                    return admin;
                }
                else{
                    System.out.println("Failed admin authorization");
                    return null;
                }
            }
            catch(Exception e){
                System.out.println("AdminsAuthorizeClient with login exception thrown: " + e.getMessage());
                return null;
            }
        }
        catch(Exception ex){
            System.out.println("AdminsAuthorizeClient exception thrown: " + ex.getMessage());
            return null;
        }
    }
}
