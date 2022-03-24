package com.luv2code.springdemo;

public class SwimmingCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swimming 30 minutes every morning";
    }
}
