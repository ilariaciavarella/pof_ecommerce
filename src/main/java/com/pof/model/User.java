package com.pof.model;

public class User {
    private static int counter = 0;

    private int ID;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
    private String document;

    public User(String name, String surname, Date birthday, String address, String document) {
        this.ID = ++counter;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.document = document;
    }
}