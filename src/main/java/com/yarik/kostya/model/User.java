package com.yarik.kostya.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {

    private String name;
    private List<Long> listOfPhoneBooksIds;

    public User(String name) {
        this.name = name;
        this.listOfPhoneBooksIds = new ArrayList<>();
    }

    public void addPhoneBookId(Long id) {
        listOfPhoneBooksIds.add(id);
    }

    public void removePhoneBookId(Long id) {
        listOfPhoneBooksIds.remove(id);
    }

    public User(String name, List<Long> listOfPhoneBooksIds) {
        this.name = name;
        this.listOfPhoneBooksIds = listOfPhoneBooksIds;
    }
}
