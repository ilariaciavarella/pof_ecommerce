package com.pof.model;

import java.util.Date;

import static com.pof.util.DataFormatter.*;

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
    public Product(String[] fields) {
        counter++;
        this.id = formatId(fields[0]);
        this.name = fields[1];
        this.insertDate = formatDate(fields[2]);
        this.price = formatPrice(fields[3]);
        this.brand = fields[4];
        this.availability = fields[5].equalsIgnoreCase("SI");
    }

    // METHODS
    @Override
    public String toString() {
        return String.format("ID: %d%n" +
                        "Nome: %s%n" +
                        "Inserito il %td/%tm/%tY%n" +
                        "Prezzo: %.2f%n" +
                        "Brand: %s%n" +
                        "%s%n%n",
                this.id, this.name,
                this.insertDate, this.insertDate,this.insertDate,
                this.price, this.brand, this.getStringAvailability());
    }

    public String toTable(){
        return String.format("| %3d | %-24s | %td/%tm/%tY  | € %6.2f | %-12s | %-15s |",
                this.id, this.name, this.insertDate, this.insertDate,this.insertDate,
                this.price, this.brand, this.getStringAvailability());
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

    public Boolean getAvailability() {
        return this.availability;
    }

    public String getStringAvailability() {
        return this.availability ? "Disponibile" : "Non disponibile";
    }

    // Setters
    public void toggleAvailability() {
        this.availability = !this.availability;
    }
}