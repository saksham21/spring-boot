package com.saksham.spingboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" endpoint that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return  "Hello World!!";
    }

    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return  "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return  "today is your lucky day.";
    }
}
