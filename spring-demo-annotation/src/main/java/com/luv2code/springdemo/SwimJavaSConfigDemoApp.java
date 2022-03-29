package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaSConfigDemoApp {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get a bean from context(spring container)
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        //call methods
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        System.out.println("email: "+coach.getEmail());

        System.out.println("team: "+coach.getTeam() );

        //close the context
        context.close();

    }
}
