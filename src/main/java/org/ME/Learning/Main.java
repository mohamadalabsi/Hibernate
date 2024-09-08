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
//!        insert the data into the database from Car class to car table
//        Car myCar = new Car();
//        myCar.setId(553);
//        myCar.setModel("Sonata");
//        myCar.setMake("hyundai");
//        BigDecimal price = new BigDecimal("12050.49");
//        myCar.setPrice(price);


//!         insert the data into the database from student class to student table
        StudentName  sn = new StudentName();
        sn.setFirstName("Mohammad");
        sn.setLastName("Al Absi");

        Student student = new Student();
        student.setId(1);
        student.setAge(20);
        student.setName(sn);


        Configuration  con = new Configuration().configure().addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the yello line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(student); //this is for inserting into the database


//         fetching the data from the database
//         myCar=(Car)session.get(Car.class, 50);
//         System.out.println(myCar);
        tx.commit();


    }
}