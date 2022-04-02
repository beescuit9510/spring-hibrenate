package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCamiloStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            // start a transaction
            session.beginTransaction();

            List<Student> students = session.createQuery("From Student s WHERE s.firstName = 'Camilo' ").getResultList();

            Student student = students.get(0);

            session.delete(student);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {

            session.close();
            factory.close();
        }
    }
}
