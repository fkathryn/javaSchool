package com.inovus.test.numbergenerator;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class NumberGenerator {
    private final String[] pool = new String[] {"A", "E", "Т", "О", "Р", "Н", "У", "К", "Х", "С", "В", "М"};
    private final String codeKazan = "116 RUS";
    private String resultNumber;

    NumberGenerator() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        resultNumber = String.format("%s%d%d%d%s%s %s",
                pool[rand.nextInt(pool.length)],
                rand.nextInt(9),
                rand.nextInt(9),
                rand.nextInt(9),
                pool[rand.nextInt(pool.length)],
                pool[rand.nextInt(pool.length)],
                codeKazan
        );
        System.out.println(resultNumber);
    }

    public String getResultNumber() {
        return resultNumber;
    }
}
