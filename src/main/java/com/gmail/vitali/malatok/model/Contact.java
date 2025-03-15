package com.gmail.vitali.malatok.model;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | Phone: " + phoneNumber + " | Address: " + address;
    }
}
