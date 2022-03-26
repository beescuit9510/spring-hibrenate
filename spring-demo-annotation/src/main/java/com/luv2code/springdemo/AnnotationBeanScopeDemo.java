package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("tennisCoach",Coach.class);

        Coach alpbaCoach = context.getBean("tennisCoach",Coach.class);

        boolean result = (coach==alpbaCoach);

        System.out.println();
        System.out.println("Pointing to the same object: "+result);
        System.out.println();
        System.out.println("Memory location for coach: "+coach);
        System.out.println();
        System.out.println("Memory location for alpbaCoach: "+alpbaCoach);

        context.close();
    }
}
