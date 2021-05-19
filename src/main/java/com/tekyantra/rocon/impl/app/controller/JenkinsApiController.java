package com.tekyantra.rocon.impl.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rocon")
public class JenkinsApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


}

