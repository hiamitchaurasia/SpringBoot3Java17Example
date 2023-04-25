package com.hiamitchaurasia.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Universe from App 2!");
        SpringApplication.run(Main.class, args);
    }
}