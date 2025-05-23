package com.example.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@Slf4j
public class Application {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);

        // Access Environment from context to log active profiles
        Environment env = context.getEnvironment();
        log.info("Active Spring profiles: {}", (Object) env.getActiveProfiles());
    }
}
