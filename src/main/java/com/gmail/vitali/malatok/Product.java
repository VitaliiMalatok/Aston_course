package com.gmail.vitali.malatok;

import java.util.Objects;

public class Product {
    private final String productName;
    private final String prodactionDate;
    private final String manufacturer;
    private final String countryOfOrigin;
    private final int price;
    private final String reservationStatus;

    public Product(String productName, String prodactionDate, String manufacturer, String countryOfOrigin, int price, String reservationStatus) {
        this.productName = productName;
        this.prodactionDate = prodactionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", prodactionDate=" + prodactionDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }
}
