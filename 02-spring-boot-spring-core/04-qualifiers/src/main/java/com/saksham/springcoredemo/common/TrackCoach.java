package com.saksham.springcoredemo.common;

import org.springframework.stereotype.Component;

// this component marks class as Spring Bean and make it available for DI
@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }
}
