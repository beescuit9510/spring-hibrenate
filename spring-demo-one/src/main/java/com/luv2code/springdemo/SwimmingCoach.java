package com.luv2code.springdemo;

public class SwimmingCoach implements Coach{

    private FortuneService fortuneService;

    public SwimmingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swimming 30 minutes every morning";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
