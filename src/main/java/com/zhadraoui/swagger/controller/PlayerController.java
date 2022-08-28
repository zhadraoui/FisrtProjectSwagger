package com.zhadraoui.swagger.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080
@RestController
@RequestMapping("/api")
// http://localhost:8080/api
public class PlayerController {

    @GetMapping("/name")
    public String getName() {
        return "Eslam Khder";
    }

    @GetMapping("/student")
    public String getStudent() {
        return "I am Stident (Eslam Khder)";
    }


}
