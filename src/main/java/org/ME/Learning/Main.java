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

//         GET and LOAD  , the difference between them that get will hit the DB even if you do not print the object , but load does not hit it without printing , only when you want to use it
        Student student = session.get(Student.class, 90); // get will give you the object
//        and also with get if you give it nonexisting Id or value for a row it will print null
//        Student student = session.load(Student.class, 90);  // load will give you a proxy object
//         try {
//             Thread.sleep(3000);
//         }catch (InterruptedException e ){
//             e.printStackTrace();
//         }
        System.out.println(student);


        session.getTransaction().commit();

        session.close();// if you have more than one session you have to close them

    }
}