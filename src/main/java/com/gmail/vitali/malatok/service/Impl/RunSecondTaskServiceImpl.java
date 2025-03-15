package com.gmail.vitali.malatok.service.Impl;

import com.gmail.vitali.malatok.model.Contact;
import com.gmail.vitali.malatok.model.PhoneBook;
import com.gmail.vitali.malatok.service.RunSecondTaskService;

public class RunSecondTaskServiceImpl implements RunSecondTaskService {
    @Override
    public void runSecondTask() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(new Contact("John", "Smith", "123-456", "New York, 5th Avenue"));
        phoneBook.add(new Contact("Alice", "Johnson", "987-654", "Los Angeles, Sunset Blvd"));
        phoneBook.add(new Contact("Bob", "Smith", "111-222", "Chicago, Michigan Ave"));
        phoneBook.add(new Contact("Emma", "Williams", "333-444", "San Francisco, Market St"));
        phoneBook.add(new Contact("Michael", "Brown", "555-666", "Houston, Main St"));

        System.out.println("Smiths: " + phoneBook.get("Smith"));
        System.out.println("Williams: " + phoneBook.get("Williams"));
        System.out.println("Brown: " + phoneBook.get("Brown"));
        System.out.println("Davis: " + phoneBook.get("Davis"));
    }
}
