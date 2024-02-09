package com.alquiteto.junior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
public class JuniorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuniorApplication.class, args);
    }

}
