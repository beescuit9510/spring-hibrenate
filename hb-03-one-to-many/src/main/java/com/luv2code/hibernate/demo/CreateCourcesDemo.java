package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourcesDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            // start a transaction
            session.beginTransaction();

            int id = 5;

            Instructor instructor = (Instructor) session.get(Instructor.class, id);

            Course course1 = new Course("the basics of shape shifting");
            Course course2 = new Course("th intermediate skills for shape shifting");
            Course course3 = new Course("the advanced topics for shape shifting");

            instructor.add(course1);
            instructor.add(course2);
            instructor.add(course3);

            session.save(course1);
            session.save(course2);
            session.save(course3);

            System.out.println(instructor);
            instructor.getCourses().forEach(System.out::println);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {

            session.close();
            factory.close();
        }
    }
}
