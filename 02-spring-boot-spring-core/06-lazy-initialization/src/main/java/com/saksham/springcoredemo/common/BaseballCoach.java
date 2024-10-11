package com.saksham.springcoredemo.common;

import org.springframework.stereotype.Component;

// this component marks class as Spring Bean and make it available for DI
@Component
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30mins in batting practice";
    }
}
