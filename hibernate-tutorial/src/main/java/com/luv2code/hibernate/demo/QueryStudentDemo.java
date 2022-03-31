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

            // start a transaction
            session.beginTransaction();

            // query students
            // above HIBERNATE 5.2 should use getResultList() instead of list()
            List<Student> students = session.createQuery("from Student").list();

            displayStudent(students);


            // query students: lastName='madrigal'
            // use the Java class and property names not a table and column names
            students = session.createQuery("from Student s where s.lastName='madrigal'").list();

            System.out.println("\n\nStudents who have last name of madrigal");
            displayStudent(students);

            // query students: firstName='Camilo' or firstName='dolores'
            students = session
                    .createQuery("from Student s where s.firstName='Camilo' OR s.firstName = 'dolores' ")
                    .list();

            System.out.println("\n\nStudents who have first name of 'Camilo' or 'dolores");
            displayStudent(students);

            // query students: where email Like 'madrigal@%''
            students = session
                    .createQuery("from Student s where s.email Like '%@gmail.com' ")
                    .list();

            System.out.println("\n\nStudents whose email ends with '@gmail.com");
            displayStudent(students);


            // commit transaction
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