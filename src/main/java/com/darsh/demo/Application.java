package com.darsh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.darsh.demo")
public class Application {

    public static void main(String[] args) throws Throwable {
    		
        SpringApplication.run(Application.class, args);
    }

}
