package com.leonardburgos.spring_console_app.controller;

import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public String springMvcGreeting() {
        String version = SpringVersion.getVersion();
        return "Spring Core Version: " + version;
    }

}
