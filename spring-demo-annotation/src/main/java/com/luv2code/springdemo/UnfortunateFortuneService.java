package com.luv2code.springdemo;

public class UnfortunateFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is your unfortunate day!";
    }
}
