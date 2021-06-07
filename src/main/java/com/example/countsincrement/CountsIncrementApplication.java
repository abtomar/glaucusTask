package com.example.countsincrement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class CountsIncrementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountsIncrementApplication.class, args);
    }

}
