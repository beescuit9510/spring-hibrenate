package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{

    private FortuneService fortuneService;

    @Autowired
    public SwimmingCoach(@Qualifier("unhappyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your swimming 30 minutes every day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
