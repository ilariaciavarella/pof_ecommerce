package com.pof.model;

public class Sales {
    private static int counter = 0;

    private int ID;
    private int productID;
    private int userID;

    public Sales(int productID, int userID) {
        this.ID = ++counter;
        this.productID = productID;
        this.userID = userID;
    }}