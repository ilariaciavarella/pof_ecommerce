package com.pof.model;

import static com.pof.util.DataFormatter.*;

public class Sale {
    // FIELDS
    private static Integer counter = 0;

    private Integer saleId;
    private Integer productId;
    private Integer userId;

    // CONSTRUCTORS
    public Sale(Integer saleId, Integer productId, Integer userId) {
        counter++;
        this.saleId = saleId;
        this.productId = productId;
        this.userId = userId;
    }

    public Sale(Integer productId, Integer userId) {
        this.saleId = ++counter;
        this.productId = productId;
        this.userId = userId;
    }

    public Sale(String[] fields) {
        counter++;
        this.saleId = formatId(fields[0]);
        this.productId = formatId(fields[1]);
        this.userId = formatId(fields[2]);
    }

    //METHODS
    // Getters
    public Integer getSaleId() {
        return saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getUserId() {
        return userId;
    }
}