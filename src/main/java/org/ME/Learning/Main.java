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

        Student student;

        Configuration  con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the  line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);

//         Caching Level 1         // if you have tow diffrent session but the same query , the query will be called once and the output will be also once
        Session session1 = sf.openSession();
        session1.beginTransaction();
        student=(Student) session1.get(Student.class, 1);
        System.out.println(student);
        session1.beginTransaction().commit();
        session1.close();



        Session session2 = sf.openSession();

        student=(Student) session1.get(Student.class, 1);
        System.out.println(student);
        session2.beginTransaction().commit(); // if you have more than one session you have to close them

// the query will be called once in this but the output will be print twice
//        Session session1 = sf.openSession();
//
//
//        student=(Student) session1.get(Student.class, 1);
//        System.out.println(student);
//
//        student=(Student) session1.get(Student.class, 1);
//        System.out.println(student);
//
//
//        session1.beginTransaction().commit();
//        session1.close();

    }
}