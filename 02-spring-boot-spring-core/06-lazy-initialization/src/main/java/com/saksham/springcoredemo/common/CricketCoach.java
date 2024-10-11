package com.saksham.springcoredemo.common;

import org.springframework.stereotype.Component;

// this component marks class as Spring Bean and make it available for DI
@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
