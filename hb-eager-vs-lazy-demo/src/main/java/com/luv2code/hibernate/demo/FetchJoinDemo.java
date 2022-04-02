package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import org.hibernate.Query;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {
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

            //option2 : hibernate query with HQL

            Query<Instructor> query = session.createQuery(
                    "select i from Instructor i " +
                            "JOIN FETCH i.courses " +
                            "WHERE i.id=:instructorId", Instructor.class);

            query.setParameter("instructorId",id);

            Instructor instructor = query.getSingleResult();

            System.out.println("\n\nluv2code : Instructor : " + instructor);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("\nsession closed!");

            System.out.println(instructor.getCourses());

            System.out.println("luv2code : Done!");
        } finally {

            session.close();
            factory.close();
        }
    }
}
