package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UnhappyFortuneService implements FortuneService{

    @Value("${unhappy.fortune}")
    private String fortune;

    @Override
    public String getFortune() {
        return fortune;
    }

    @PostConstruct
    public void afterConstruct(){
        System.out.println(">> UnhappyFortuneService: inside afterConstruct() method");
    }

    @PreDestroy
    public void beforeDestruction(){
        System.out.println(">> UnhappyFortuneService: inside beforeDestruction() method");
    }
}
