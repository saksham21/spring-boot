package com.saksham.spingboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for coach.name and field.name from application.properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/" endpoint that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return  "Hello " + teamName;
    }

    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return  "Run a hard 5k! By - " + coachName;
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return  "today is your lucky day.";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return  "coachName is " + coachName + " , teamName is " + teamName;
    }
}
