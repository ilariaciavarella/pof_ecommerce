package com.pof.model;

public class Product {
    private static int counter = 0;

    private int ID;
    private String name;
    private Date insertDate;
    private double price;
    private String brand;
    private boolean available;

    public Product(String name, Date insertDate, double price, String brand, boolean available) {
        this.ID = ++counter;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price;
        this.brand = brand;
        this.available = available;
    }
}