package com.yarik.kostya.model;

import lombok.Getter;

@Getter
public class PhoneRecord {
    private static Long idCounter = 0L;

    private Long id;
    private String name;
    private String phoneNumber;

    public PhoneRecord(String name, String phoneNumber) {
        this.id = ++idCounter;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
