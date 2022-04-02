package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            // start a transaction
            session.beginTransaction();

            Course course = new Course("Precognition");

            course.addReview(new Review("We don't talk about the instructor"));
            course.addReview(new Review("It was my first day of the course"));
            course.addReview(new Review("it was our first day of the course"));

            System.out.println("Saving the course and reviews in the course (cascade)");
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
