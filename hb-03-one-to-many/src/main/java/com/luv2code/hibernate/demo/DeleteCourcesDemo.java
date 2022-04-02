package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourcesDemo {
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

            System.out.println("Instructor : "+instructor);

            System.out.println("Courses: "+instructor.getCourses());

            System.out.println(instructor);
            instructor.getCourses().forEach(System.out::println);

            System.out.println(instructor.getCourses().get(0));

            session.delete(instructor.getCourses().get(0));


//            int id = 10;
//
//            Course course = (Course) session.get(Course.class,id);
//
//            System.out.println("Deleting course: "+course);
//
//            session.delete(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {

            session.close();
            factory.close();
        }
    }
}
