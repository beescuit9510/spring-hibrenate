package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") //explicit component names
@Component //default component names
public class TennisCoach implements Coach{

     @Override
    public String getDailyWorkout() {
        return "Practice your backand volley";
    }
}
