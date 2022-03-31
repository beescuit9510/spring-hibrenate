package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            System.out.println("Deleting student: "+student);
            session.delete(student);

            session.getTransaction().commit();


            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }

}
