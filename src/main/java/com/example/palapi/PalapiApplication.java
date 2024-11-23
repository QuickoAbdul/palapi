package com.example.palapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.*;

@SpringBootApplication
public class PalapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalapiApplication.class, args);
        out.println("Hello World");
    }

}
