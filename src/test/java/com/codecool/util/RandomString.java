package com.codecool.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomString {
    public static String generateRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}

