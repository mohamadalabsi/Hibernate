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

//         HQL
        Session session = sf.openSession();
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();// if you have more than one session you have to close them

    }
}