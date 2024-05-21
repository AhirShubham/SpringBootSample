package com.shubham.springboot.journal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("health")
@RestController//@Component + @ResponseBody - to serilaize objects to HttpResponse
public class HealthCheck {

    @GetMapping("health-check")
    public String healthCheck(){
        return "UP and Running";
    }

}
