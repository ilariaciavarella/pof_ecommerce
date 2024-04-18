package com.pof.model;

import java.util.Date;

public class Product {
    // FIELDS
    private static Integer counter = 0;

    private Integer id;
    private String name;
    private Date insertDate;
    private Double price;
    private String brand;
    private Boolean availability;

    // CONSTRUCTORS
    public Product() {
        counter++;
    }

    public Product(Integer id, String name, Date insertDate, Double price, String brand, Boolean availability) {
        counter++;
        this.id = id;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price;
        this.brand = brand;
        this.availability = availability;
    }

    // METHODS
}