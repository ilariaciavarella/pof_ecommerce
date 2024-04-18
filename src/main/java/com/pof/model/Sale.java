package com.pof.model;

public class Sale {
    // FIELDS
    private static Integer counter = 0;

    private Integer saleId;
    private Integer productId;
    private Integer userId;

    // CONSTRUCTORS
    public Sale() {
        counter++;
    }

    public Sale(Integer saleId, Integer productId, Integer userId) {
        counter++;
        this.saleId = saleId;
        this.productId = productId;
        this.userId = userId;
    }

    //METHODS
}