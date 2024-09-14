package org.ME.Learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.service.ServiceRegistry;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {

        Car car;


        Configuration  con = new Configuration().configure().addAnnotatedClass(Car.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the  line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);

//         Caching Level  2 with query
        Session session1 = sf.openSession();
        session1.beginTransaction();
        Query q1 =session1.createQuery("FROM Car WHERE id=55");
        q1.setCacheable(true);
        car=(Car)q1.uniqueResult();
        System.out.println(car);
        session1.getTransaction().commit();
        session1.close();



        Session session2 = sf.openSession();
        session2.beginTransaction();
        Query q2 =session2.createQuery("FROM Car WHERE id=55");
        q2.setCacheable(true);
        car=(Car)q2.uniqueResult();
        System.out.println(car);
        session2.getTransaction().commit();
        session2.close();// if you have more than one session you have to close them

    }
}