package com.gmail.vitali.malatok.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<Contact>> phoneBook = new HashMap<>();

    public void add(Contact contact) {
        String lastName = contact.getLastName();
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(contact);
    }

    public List<Contact> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
}
