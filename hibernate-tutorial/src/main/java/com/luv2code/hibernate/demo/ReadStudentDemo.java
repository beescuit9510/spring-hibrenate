package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
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

            // create a student object
            System.out.println("creating a new student object");
            Student tempStudent = new Student("Camilo", "madrigal", "Camilo@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("saving the new student object");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // READ !

            //find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id : primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student student = (Student) session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + student);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
