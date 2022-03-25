package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    //Spring provides us a object factory that is a spring container
    //Spring factory is going to
    // create all the appropriate beans and dependencies and
    // inject those dependencies and
    // returns fully assembled objects

    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        // DI ex clean code system 157p) MyService myService = (MyService)(jndiContext.lookup(“NameOfMyService”));
        Coach coach = context.getBean("myCoach",Coach.class);   //bean id, coach interface

        //call methods on the bean
        System.out.println(coach.getDailyWorkout());

        //let's call our new method for fortunes
        System.out.println(coach.getDailyFortune());

        //close the context
        context.close();
    }
}
