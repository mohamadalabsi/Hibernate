package org.ME.Learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setId(553);
        myCar.setModel("Sonata");
        myCar.setMake("hyundai");
        BigDecimal price = new BigDecimal("12050.49");
        myCar.setPrice(price);

        Configuration  con = new Configuration().configure().addAnnotatedClass(Car.class  );

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the yello line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(myCar);

        tx.commit();

    }
}