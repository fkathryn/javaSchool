package com.inovus.test.numbergenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumberGeneratorApplication.class, args);
        NumberGenerator number = new NumberGenerator();
        System.out.println(number.getResultNumber());
    }
}
