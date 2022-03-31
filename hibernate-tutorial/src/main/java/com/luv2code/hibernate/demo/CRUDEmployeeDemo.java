package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CRUDEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Employee dolores = saveEmployee(sessionFactory);

            getEmployById(sessionFactory, dolores.getId());

            getEmployees(sessionFactory);

            deleteEmployee(sessionFactory, dolores.getId());


        } finally {
            sessionFactory.close();
        }
    }

    private static Employee saveEmployee(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Employee employeeToSave1 = new Employee("Bruno","Madrigal","Encanto");
        Employee employeeToSave2 = new Employee("Camilo","Madrigal","Encanto");
        Employee employeeToSave3 = new Employee("Dolores","Madrigal","Encanto");

        session.save(employeeToSave1);
        session.save(employeeToSave2);
        session.save(employeeToSave3);

        System.out.println("\nEmployees to save : ");
        System.out.println(employeeToSave1);
        System.out.println(employeeToSave2);
        System.out.println(employeeToSave3);

        session.getTransaction().commit();

        return employeeToSave3;
    }

    private static void getEmployById(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Employee savedEmployee = (Employee) session.get(Employee.class, id);
        System.out.println("\nEmployee to get : ");
        System.out.println(savedEmployee);

        session.getTransaction().commit();
    }


    private static void getEmployees(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<Employee> employees = session
                .createQuery("from Employee e where e.company like '%Encanto%'")
                .list();

        System.out.println("\nEmployees whose company is Encanto  : ");

        employees.forEach(System.out::println);

        session.getTransaction().commit();
    }

    private static void deleteEmployee(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class, id);

        System.out.println("\nEmployee to delete id ("+id+"): " + employee);

        session.delete(employee);

        session.getTransaction().commit();

    }


}
