package com.academy.spring.web;

import com.academy.spring.configs.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloResource {

    private AppConfig properties;

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/print")
    public String print() {
        return "name: " + properties.getName() + ", email: " + properties.getEmail();
    }

    @Autowired
    public void setAppConfig(AppConfig properties) {
        this.properties = properties;
    }
}
