package com.gmail.vitali.malatok;

import java.util.Objects;

public class Product {
    public   String productName;
    public   String prodactionDate;
    public   String manufacturer;
    public   String countryOfOrigin;
    public   int price;
    public   String reservationStatus;

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
        return  "Product{" +
                "productName='" + productName + '\'' +
                ", prodactionDate=" + prodactionDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }
}
