package com.jpa.jpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class JpaTestApplication {

    public static void main(String[] args) {
        
        SpringApplication app = new SpringApplication(JpaTestApplication.class);
        app.run(args);
    }

}
