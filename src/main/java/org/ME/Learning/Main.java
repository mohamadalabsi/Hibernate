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

//         Hibernate Object States
        Student student = new Student();
        student.setRollNumber(70);
        student.setName("mohand alabsi");
        student.setMarks(50);
        session.save(student); // the object still in the persistent state
        student.setMarks(80);  // this also will change in the database

        session.remove(student);// the object will not be stored in the database


        session.getTransaction().commit();
//        lets say we have here some operation and then I will change student.setMarks(44); again but i do not want the changes to be in the database and i should be after commit
        session.detach(student);
        student.setMarks(90);
        session.close();// if you have more than one session you have to close them

    }
}