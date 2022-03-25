package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same
        boolean result = (coach == alphaCoach);

        System.out.println();
        System.out.println("Pointing to the same object: "+result);
        System.out.println();
        System.out.println("Memory location for coach: "+coach);
        System.out.println();
        System.out.println("Memory location for alphaCoach: "+alphaCoach);


        context.close();
    }
}
