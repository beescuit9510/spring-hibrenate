package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AddCoursesForDoloresDemo {
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

            Course course1 = new Course("super hearing by dolores");
            Course course2 = new Course("precognition by bruno");
            Course course3 = new Course("growing roses and Cacti by isabella");

            course1.addStudent(student);
            course2.addStudent(student);
            course3.addStudent(student);
//
//            student.getCourses().add(course1);
//            student.getCourses().add(course2);
//            student.getCourses().add(course3);

            session.save(course1);
            session.save(course2);
            session.save(course3);
            session.update(student);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {

            session.close();
            factory.close();
        }
    }
}
