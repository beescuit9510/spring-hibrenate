package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {


            // start a transaction
            session.beginTransaction();

            int id = 1;

            Instructor instructor =  (Instructor) session.get(Instructor.class, id);

            System.out.println("Found instructor : "+instructor);

            if (instructor!=null){
                System.out.println("Deleting : "+instructor);

                //Note : will ALSO delete associated "details" object
                //Because of CascadeType.ALL
                session.delete(instructor);

            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
