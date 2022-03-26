package com.luv2code.springdemo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] data = {"Fortune1","Fortune2","Fortune3"};

    private Random myRandom = new Random();

    @Override
    public String getFortune() {

        int max = data.length;

        int index = myRandom.nextInt(max);

        String fortune = data[index];

        return fortune;
    }
}
