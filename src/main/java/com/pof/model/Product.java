package com.pof.model;
import java.text.*;
import java.util.*;

public class Product {
    private static int counter = 0;

    private Integer ID;
    private String name;
    private Date insertDate;
    private Double price;
    private String brand;
    private Boolean available;

    public Product() {
        counter++;
    }

    public Product(Integer ID, String name, Date insertDate, Double price, String brand, Boolean available) {
        this.ID = ID;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price;
        this.brand = brand;
        this.available = available;
    }

    public void setID(String IDString) {
        this.ID = Integer.parseInt(IDString);
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setInsertDate(String insertDateString) {

        insertDate.parse(insertDateString);
        this.insertDate = insertDate;
    }*/

    public void setPrice(String priceString) {
        Double price = Double.parseDouble(priceString);
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAvailable(String availableString) {
        this.available = availableString == "SI" ? true : false;
    }

    public String getInsertDate() {
        return this.insertDate.toString();
    }

    public String getPrice() {
        return this.price.toString();
    }

    public String isAvailable() {
        return this.available.toString();
    }

    @Override
    public String toString() {
        return String.format("ID: %d%nNome: %s%nData di inserimento: %td/%tm/%tY%nPrezzo: €%.2f%nMarca: %s%nDisponibile: %b%n", this.ID, this.name, this.insertDate, this.insertDate, this.insertDate, this.price, this.brand, this.available);
    }
}