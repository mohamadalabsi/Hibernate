package org.ME.Learning;


import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


public class Main {
    public static void main(String[] args) {




        Configuration  con = new Configuration().configure().addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the  line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();


        session.getTransaction().commit();

        session.close();// if you have more than one session you have to close them

    }
}