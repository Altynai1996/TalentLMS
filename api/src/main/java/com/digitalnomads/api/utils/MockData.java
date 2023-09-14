package com.digitalnomads.api.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class MockData {
    private static final Faker faker=new Faker(new Locale("EN"));
    public static String generateName(){
        return faker.name().firstName();
    }
    public static String generateLastName(){
        return faker.name().firstName();
    }
    public static String generateLogin() {
        return faker.name().username();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return faker.internet().password(8, 10, true, true, true);
    }
}


