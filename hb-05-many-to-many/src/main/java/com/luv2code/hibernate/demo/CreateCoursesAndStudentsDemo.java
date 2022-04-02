package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {
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

            Course course = new Course("advanced topics for Precognition2");

            Student student1 = new Student("Dolores","Madrigal","dolores@gmail.com");
            Student student2 = new Student("Camilo","Madrigal","camilo@gmail.com");

            course.addStudent(student1);
            course.addStudent(student2);

            System.out.println(student1);
            System.out.println(student2);
            System.out.println(course);
            System.out.println(course.getStudents());

            session.save(student1);
            session.save(student2);
            session.save(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {

            session.close();
            factory.close();
        }
    }
}
