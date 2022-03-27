package com.luv2code.springdemo;

public class GamingCoach implements Coach{
    private FortuneService fortuneService;

    public GamingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "GAMING ALL DAY";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
