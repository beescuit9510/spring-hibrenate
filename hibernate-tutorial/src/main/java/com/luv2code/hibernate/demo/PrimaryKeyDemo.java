package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            // use the session object to save Java object

            // create 3 student objects
            System.out.println("creating 3 new student objects");
            Student tempStudent1 = new Student("pepa","madrigal","pepa@gmail.com");
            Student tempStudent2 = new Student("bruno","madrigal","bruno@gmail.com");
            Student tempStudent3 = new Student("dolores","madrigal","dolores@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the 3 student objects
            System.out.println("saving the new student objects");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }


}
