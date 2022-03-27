package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GamingDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfig.class);

        Coach coach = context.getBean("gamingCoach", Coach.class);

        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());

        context.close();

    }
}
