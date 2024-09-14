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

        Car car=null;
//        Student student;
//        Laptop laptop;

        Configuration  con = new Configuration().configure().addAnnotatedClass(Car.class);
//        Configuration  con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the  line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);

//         Caching Level  2
        Session session1 = sf.openSession();
        session1.beginTransaction();
        car=(Car) session1.get(Car.class,553);
        System.out.println(car);
        session1.getTransaction().commit();
        session1.close();


//
        Session session2 = sf.openSession();
        session2.beginTransaction();
        car=(Car) session2.get(Car.class,553);
        System.out.println(car);
        session2.getTransaction().commit();
        session2.close();// if you have more than one session you have to close them

//        Caching Level  2 // if you have two table (i am using student table but it connected with laptop table ) like here it will not work for some reason
//        Session session1 = sf.openSession();
//        session1.beginTransaction();
//        student=(Student) session1.get(Student.class,1);
//        System.out.println(student);
//        session1.getTransaction().commit();
//        session1.close();
//
//
////
//        Session session2 = sf.openSession();
//        session2.beginTransaction();
//        student=(Student) session2.get(Student.class,1);
//        System.out.println(student);
//        session2.getTransaction().commit();
//        session2.close();// if you have more than one session you have to close them

    }
}