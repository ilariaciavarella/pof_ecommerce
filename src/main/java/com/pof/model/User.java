package com.pof.model;

import java.util.Date;
import static com.pof.util.DataFormatter.*;

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
    public User(String[] fields) {
        counter++;
        this.id = formatId(fields[0]);
        this.name = capitalise(fields[1]);
        this.surname = fields[2];
        this.birthdate = formatDate(fields[3]);
        this.address = fields[4];
        this.document = fields[5].toLowerCase();
    }

    // METHODS
    // Getters
    public static Integer getNextId() {
        Integer nextId = counter;
        return ++nextId;
    }

    public Integer getId() {
        return this.id;
    }
}