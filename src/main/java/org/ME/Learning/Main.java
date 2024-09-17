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


//         HQL
//        I have dropped the car table and made a new one

//        Random rand = new Random();
//        for (int i = 0; i < 50; i++) {
//            Student student = new Student();
//            student.setRollNumber(i);
//            student.setName("Name"+i);
//            student.setMarks(rand.nextInt(100));
//            session.save(student);
//
//        }

//        Query q = session.createQuery("from Student where rollNumber=7");  // more than one row use uniqueResult , others than that use the List
//        List<Student> students = q.list();
////          Student student = (Student) q.uniqueResult();
////          System.out.println(student);
//        for (Student s : students) {
//            System.out.println(s);
//        }

//        Query q = session.createQuery("select rollNumber, name ,marks   from Student where rollNumber=7"); // here if you specify the columns and the row
//          Object[] student = (Object[]) q.uniqueResult();
//        System.out.println(student[0]+" "+student[1]+ " "+student[2]);
//
//        for (Object o : student) {
//            System.out.println(o);
//        }

//        Query q = session.createQuery("select rollNumber, name ,marks   from Student s where s.marks>70"); // here if you specify the columns , but a list , here s just to specify the table if you have different table with the same column specially if u use joins
//       List<Object[]> student = (  List<Object[]>  ) q.list();
//        for (Object[] s : student) {
//            System.out.println(s[0]+" "+s[1]+ " "+s[2]);
//        }

//        other operation with HQL
//        int number=70;
//        Query q = session.createQuery("select sum(marks)   from Student s where s.marks>:number" /*+ number*/);
////      Object marks = (  Object  ) q.uniqueResult();
//        q.setParameter("number", number);
//        Long marks = (  Long  ) q.uniqueResult();//long and not int
//
//        System.out.println(marks);
//

//        SQL  Native Queries
//        SQLQuery sqlQuery = session.createSQLQuery("select * from student");
//        sqlQuery.addEntity(Student.class);
//        List<Student> students = sqlQuery.list();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
        SQLQuery sqlQuery = session.createSQLQuery("select name ,marks from student WHERE  marks > 60");
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List  students = sqlQuery.list();

        for (Object student : students) {
            Map m = (Map) student; // to convert it to a map
            System.out.println(m.get("name")+" "+m.get("marks"));
        }
////       or
//        SQLQuery sqlQuery = session.createSQLQuery("select name ,marks from student WHERE  marks > 60");
//        List< Object[] >student = (List<Object[]>) sqlQuery.list();
//
//        for (Object[] students : student) {
//            System.out.println(students[0]+" "+students[1]);
//
//        }

        session.getTransaction().commit();
        session.close();// if you have more than one session you have to close them

    }
}