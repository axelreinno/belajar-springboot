package com.academy.spring.configs;

import jakarta.mail.Authenticator;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import jakarta.mail.PasswordAuthentication;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ApplicationConfig {
    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("d1268cdd35952e", "34ff9375651117");
    }

    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
        return properties;
    }

    @Bean
    public Session mailSession(@Qualifier("properties") Properties properties, PasswordAuthentication authentication) {
        System.out.println(properties.toString());
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
    }
}