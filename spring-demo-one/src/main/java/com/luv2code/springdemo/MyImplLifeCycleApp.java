package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyImplLifeCycleApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("practice-beanLifeCycle-applicationContext.xml");

        Coach mySingletonCoach = context.getBean("mySingletonCoach",Coach.class);
        Coach mySingletonCoach2 = context.getBean("mySingletonCoach",Coach.class);

        Coach myPrototypeCoach = context.getBean("myPrototypeCoach",Coach.class);
        Coach myPrototypeCoach2 = context.getBean("myPrototypeCoach",Coach.class);

        boolean singletonResult = (mySingletonCoach==mySingletonCoach2);
        boolean prototypeResult = (myPrototypeCoach==myPrototypeCoach2);

        System.out.println("singleton == singleton : "+singletonResult);
        System.out.println("prototype == prototype : "+prototypeResult);

        System.out.println("mySingletonCoach : "+mySingletonCoach);
        System.out.println("mySingletonCoach2 : "+mySingletonCoach2);

        System.out.println("myPrototypeCoach : "+myPrototypeCoach);
        System.out.println("myPrototypeCoach2 : "+myPrototypeCoach2);

        context.close();

    }
}
