package Dao.Impl;

import Classes.Clients;
import Classes.Orders;
import Dao.CarsDao;
import Classes.Cars;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarsDaoImpl implements CarsDao {
    @Override
    public void save(Cars car) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(car);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("CarsSave Exception thrown: " + e.getMessage());
        }
    }


    @Override
    public void delete(Cars car) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(car);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("CarsDelete exception thrown: " + e.getMessage());
        }
    }

    @Override
    public Cars findById(int id) {
        try {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cars.class, id);
        } catch (Exception e) {
            System.out.println("CarsFindById exception thrown: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Orders findOrderByCarId(int id) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Cars car = session.get(Cars.class, id);
            Query<Orders> query = session.createQuery("From Orders WHERE car_id = :param").setParameter("param", car);
            Orders order = query.getResultList().get(0);
            return order;
        } catch (Exception e) {
            System.out.println("CarsFindOrderByCarId exception thrown: " + e.getMessage());
            return null;
        }
    }


    @Override
    public List<Cars> findCarsByCarNot(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            List<Cars> cars = null;
            if (brand != null) {
                if (manufacturer != null) {
                    if (technical_not != null) {
                        if (addition_devices != null) {
                            if (costumer_not != null) {
                                Query<Cars> query;
                                if (mutable_not != null) {
                                    query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                                }
                                else {
                                    query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                                }
                                cars =query.getResultList();
                            }
                            else if (mutable_not != null) {
                                Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param5", mutable_not);
                                cars =query.getResultList();
                            }
                            else {
                                Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices);
                                cars =query.getResultList();
                            }
                        }
                        else if (costumer_not != null) {
                            Query<Cars> query;
                            if (mutable_not != null) {
                                query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                            }
                            else {
                                query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param5", mutable_not);
                            }
                            cars =query.getResultList();
                        }
                        else if (mutable_not != null) {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                        else {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)  and (technical_not = :param2) ").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param2", technical_not);
                            cars =query.getResultList();
                        }
                    }
                    else if (addition_devices != null) {
                        if (costumer_not != null) {
                            Query<Cars> query;
                            if (mutable_not != null) {
                                query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                            }
                            else {
                                query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1) and (addition_devices = :param3) and (costumer_not = :param4)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                            }
                            cars =query.getResultList();
                        }
                    }
                    else if (costumer_not != null) {
                        if (mutable_not != null) {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                        else {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                    }
                    else if (mutable_not != null) {
                        Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param1", manufacturer).setParameter("param5", mutable_not);
                        cars =query.getResultList();
                    }
                    else {
                        Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (manufacturer = :param1)").setParameter("param", brand).setParameter("param1", manufacturer);
                        cars =query.getResultList();
                    }
                }
                else if (technical_not != null) {
                    if (addition_devices != null) {
                        if (costumer_not != null) {
                            Query<Cars> query;
                            if (mutable_not != null) {
                                query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                            }
                            else {
                                query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4)").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                            }
                            cars =query.getResultList();
                        }
                        else if (mutable_not != null) {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param)  and (technical_not = :param2) and (addition_devices = :param3) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                        else {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2) and (addition_devices = :param3) ").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param3", addition_devices);
                            cars =query.getResultList();
                        }
                    }
                    else if (costumer_not != null) {
                        if (mutable_not != null) {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                        else {
                            Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                    }
                    else if (mutable_not != null) {
                        Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param2", technical_not).setParameter("param5", mutable_not);
                        cars =query.getResultList();
                    }
                    else {
                        Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (technical_not = :param2)").setParameter("param", brand).setParameter("param2", technical_not);
                        cars =query.getResultList();
                    }
                }
                else if (addition_devices != null) {
                    if (costumer_not != null) {
                        Query<Cars> query;
                        if (mutable_not != null) {
                            query = session.createQuery("From Cars WHERE (brand = :param) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                        }
                        else {
                            query = session.createQuery("From Cars WHERE (brand = :param) and (addition_devices = :param3) and (costumer_not = :param4)").setParameter("param", brand).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                        }
                        cars =query.getResultList();
                    }
                }
                else if (costumer_not != null) {
                    Query<Cars> query;
                    if (mutable_not != null) {
                        query = session.createQuery("From Cars WHERE (brand = :param) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                    }
                    else {
                        query = session.createQuery("From Cars WHERE (brand = :param) and (costumer_not = :param4) ").setParameter("param", brand).setParameter("param4", costumer_not);
                    }
                    cars =query.getResultList();
                }
                else if (mutable_not != null) {
                    Query<Cars> query = session.createQuery("From Cars WHERE (brand = :param) and (mutable_not = :param5)").setParameter("param", brand).setParameter("param5", mutable_not);
                    cars =query.getResultList();
                }
                else {
                    Query<Cars> query = session.createQuery("From Cars WHERE brand = :param ").setParameter("param", brand);
                    cars =query.getResultList();
                }
            } //brand
            else if (manufacturer != null) {
                if (technical_not != null) {
                    if (addition_devices != null) {
                        if (costumer_not != null) {
                            Query<Cars> query;
                            if (mutable_not != null) {
                                query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                            }
                            else {
                                query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                            }
                            cars =query.getResultList();
                        }
                        else if (mutable_not != null) {
                            Query<Cars> query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param5", mutable_not);
                            cars =query.getResultList();
                        }
                        else {
                            Query<Cars> query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2) and (addition_devices = :param3)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param3", addition_devices);
                            cars =query.getResultList();
                        }
                    }
                    else if (costumer_not != null) {
                        Query<Cars> query;
                        if (mutable_not != null) {
                            query = session.createQuery("From Cars WHERE  (manufacturer = :param1)  and (technical_not = :param2) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                        }
                        else {
                            query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2) and (costumer_not = :param4)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param4", costumer_not);
                        }
                        cars =query.getResultList();
                    }
                    else if (mutable_not != null) {
                        Query<Cars> query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param2", technical_not).setParameter("param5", mutable_not);
                        cars =query.getResultList();
                    }
                    else {
                        Query<Cars> query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (technical_not = :param2)").setParameter("param1", manufacturer).setParameter("param2", technical_not);
                        cars =query.getResultList();
                    }
                }
                else if (addition_devices != null) {
                    if (costumer_not != null) {
                        Query<Cars> query;
                        if (mutable_not != null) {
                            query = session.createQuery("From Cars WHERE (manufacturer = :param1) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                        }
                        else {
                            query = session.createQuery("From Cars WHERE (manufacturer = :param1) and (addition_devices = :param3) and (costumer_not = :param4)").setParameter("param1", manufacturer).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                        }
                        cars =query.getResultList();
                    }
                }
                else if (costumer_not != null) {
                    Query<Cars> query;
                    if (mutable_not != null) {
                        query = session.createQuery("From Cars WHERE (manufacturer = :param1) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                    }
                    else {
                        query = session.createQuery("From Cars WHERE (manufacturer = :param1)  and (costumer_not = :param4)").setParameter("param1", manufacturer).setParameter("param4", costumer_not);
                    }
                    cars =query.getResultList();
                }
                else if (mutable_not != null) {
                    Query<Cars> query = session.createQuery("From Cars WHERE (manufacturer = :param1) and (mutable_not = :param5)").setParameter("param1", manufacturer).setParameter("param5", mutable_not);
                    cars =query.getResultList();
                }
                else {
                    Query<Cars> query = session.createQuery("From Cars WHERE manufacturer = :param1 ").setParameter("param1", manufacturer);
                    cars =query.getResultList();
                }
            }//man
            else if (technical_not != null) {
                if (addition_devices != null) {
                    if (costumer_not != null) {
                        Query<Cars> query;
                        if (mutable_not != null) {
                            query = session.createQuery("From Cars WHERE (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                        }
                        else {
                            query = session.createQuery("From Cars WHERE (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                        }
                        cars =query.getResultList();
                    }
                    else if (mutable_not != null) {
                        Query<Cars> query = session.createQuery("From Cars WHERE (technical_not = :param2) and (addition_devices = :param3) and (mutable_not = :param5)").setParameter("param2", technical_not).setParameter("param3", addition_devices).setParameter("param5", mutable_not);
                        cars =query.getResultList();
                    }
                    else {
                        Query<Cars> query = session.createQuery("From Cars WHERE (technical_not = :param2) and (addition_devices = :param3)").setParameter("param2", technical_not).setParameter("param3", addition_devices);
                        cars =query.getResultList();
                    }
                }
                else if (costumer_not != null) {
                    Query<Cars> query;
                    if (mutable_not != null) {
                        query = session.createQuery("From Cars WHERE (technical_not = :param2) and (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param2", technical_not).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                    }
                    else {
                        query = session.createQuery("From Cars WHERE (technical_not = :param2) and (costumer_not = :param4)").setParameter("param2", technical_not).setParameter("param4", costumer_not);
                    }
                    cars =query.getResultList();
                }
                else if (mutable_not != null) {
                    Query<Cars> query = session.createQuery("From Cars WHERE (technical_not = :param2) and (mutable_not = :param5)").setParameter("param2", technical_not).setParameter("param5", mutable_not);
                    cars =query.getResultList();
                }
                else {
                    Query<Cars> query = session.createQuery("From Cars WHERE technical_not = :param2").setParameter("param2", technical_not);
                    cars =query.getResultList();
                }
            }//tech
            else if (addition_devices != null) {
                if (costumer_not != null) {
                    Query<Cars> query;
                    if (mutable_not != null) {
                        query = session.createQuery("From Cars WHERE (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param3", addition_devices).setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                    }
                    else {
                        query = session.createQuery("From Cars WHERE (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param3", addition_devices).setParameter("param4", costumer_not);
                    }
                    cars =query.getResultList();
                }
                else if (mutable_not != null) {
                    Query<Cars> query = session.createQuery("From Cars WHERE (addition_devices = :param3) and (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param3", addition_devices).setParameter("param5", mutable_not);
                    cars =query.getResultList();
                }
                else {
                    Query<Cars> query = session.createQuery("From Cars WHERE (addition_devices = :param3) ").setParameter("param3", addition_devices);
                    cars =query.getResultList();
                }
            }//add
            else if (costumer_not != null) {
                Query<Cars> query;
                if (mutable_not != null) {
                    query = session.createQuery("From Cars WHERE (costumer_not = :param4) and (mutable_not = :param5)").setParameter("param4", costumer_not).setParameter("param5", mutable_not);
                }
                else {
                    query = session.createQuery("From Cars WHERE costumer_not = :param4").setParameter("param4", costumer_not);
                }
                cars =query.getResultList();
            }//cost
            else if (mutable_not != null) {
                Query<Cars> query = session.createQuery("From Cars WHERE mutable_not = :param5").setParameter("param5", mutable_not);
                cars =query.getResultList();
            }//ch
            else {
                System.out.println("Warning :: findCarsByCarNot has empty attributes");
            }
            session.close();
        return cars;
        }
        catch (Exception e) {
            System.out.println("findCarsByCarNot exception thrown: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void changeCarByCarNot(Cars car) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(car);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("CarsChangeCarByCarNot exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void changeCarsByCarNot(List<Cars> cars) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            //session =  HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.beginTransaction();
            for (Cars car : cars){
                session.update(car);
            }
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("CarsChangeCarsByCarNot exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void addClientToCar(Cars car, Clients client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(car);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("CarsAddClientToCar exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void deleteCars(List<Cars> cars) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            for (Cars car : cars) {
                Transaction tx1 = session.beginTransaction();
                session.delete(car);
                tx1.commit();
            }
            session.close();
        }
        catch (Exception e){
            System.out.println("CarsDeleteCars exception thrown: " + e.getMessage());
        }
    }
}
