package com.digitalnomads.api.utils;

import com.digitalnomads.api.entities.User;

public class EntityManager {
    public static User generateUser() {
        return User.builder()
                .firstName(MockData.generateName())
                .lastName(MockData.generateLastName())
                .email(MockData.generateEmail())
                .login(MockData.generateLogin())
                .password(MockData.generatePassword())
                .build();
    }
    }

