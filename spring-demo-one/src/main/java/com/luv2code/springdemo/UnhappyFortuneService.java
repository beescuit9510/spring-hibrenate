package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnhappyFortuneService implements FortuneService{

    private List<String> fortunes;
    private Random rand;
    private int max;
    private int min;

    {
        fortunes = new ArrayList<>();
        fortunes.add("Today is your unlucky day!");
        fortunes.add("Today is your unhappy day!");
        fortunes.add("Today is your unfortunate day!");
        rand = new Random();
        max = fortunes.size()-1;
        min = 0;

    }

    @Override
    public String getFortune() {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return fortunes.get(randomNum);
    }
}
