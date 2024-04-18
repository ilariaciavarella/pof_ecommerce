package com.pof.model;

import java.util.Date;

public class User {
    // FIELDS
    private static Integer counter = 0;

    private Integer id;
    private String name;
    private String surname;
    private Date birthdate;
    private String address;
    private String document;

    // CONSTRUCTORS
    public User() {
        counter++;
    }

    public User(Integer id, String name, String surname, Date birthdate, String address, String document) {
        counter++;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
        this.document = document;
    }

    // METHODS

    @Override
    public String toString() {
        return String.format("ID: %d - Name: %s - Surname: %s - Birthdate: %td/%tm/%tY - Address: %s - Document: %s",
                id, name, surname, birthdate, birthdate, birthdate, address, document);
    }
}