package org.ME.Learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setId(1001);
        myCar.setModel("Kia");
        myCar.setMake("Sephia");
        BigDecimal price = new BigDecimal("8248.49");
        myCar.setPrice(price);

        Configuration  config = new Configuration();
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        session.save(myCar);

    }
}