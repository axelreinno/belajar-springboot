package com.academy.spring.web;

import com.academy.spring.configs.MailConfig;
import com.academy.spring.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    public boolean send(@RequestBody String message) {
        try {
            emailService.sendMail(message);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
