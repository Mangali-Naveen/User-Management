package com.user.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
	MALE,
	FEMALE,
	OTHERS;

    @JsonCreator
    public static Gender from(String value) {
        try {
            return Gender.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid gender value: " + value);
        }
    }

}
