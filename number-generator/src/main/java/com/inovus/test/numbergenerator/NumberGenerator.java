package com.inovus.test.numbergenerator;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;


public class NumberGenerator {
    private final char[] pool = new char[] {'A', 'Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};
    private final String codeKazan = "116 RUS";
    private String resultNumber;
    private SecureRandom random = new SecureRandom();

    NumberGenerator() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        int number = randomNumbers();
        System.out.println(pool[rand.nextInt(pool.length)] + " " + number + " " + codeKazan);
    }

    private int randomNumbers() {
        int result = 0;
        return result;
    }
}
