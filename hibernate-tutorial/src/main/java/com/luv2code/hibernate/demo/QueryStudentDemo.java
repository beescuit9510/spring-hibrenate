package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // get a new session and start transation
            session = factory.getCurrentSession();
            session.beginTransaction();

            //get student based on the id : primary key
            System.out.println("\nGetting student with id: "+studentId);

            Student student = (Student) session.get(Student.class, studentId);

            System.out.println("Updating students...");
            student.setFirstName("antonio");

            // commit transaction
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update firstName for all students");

            session.createQuery("update Student set lastName='Madrigal'")
                    .executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }

    private static void displayStudent(List<Student> students) {
        students.forEach(System.out::println);
    }
}
