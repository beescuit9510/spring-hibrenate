package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfig {

    @Bean
    public GamingCoach gamingCoach(){
        return new GamingCoach(unfortunateFortuneService());
    }

    @Bean
    public FortuneService unfortunateFortuneService(){
        return new UnfortunateFortuneService();
    }
}
