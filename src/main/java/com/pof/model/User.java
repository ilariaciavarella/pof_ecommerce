/*
package com.pof.model;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import com.pof.model.*;
import java.text.*;

public class User {
    private static int counter = 0;

    private Integer ID;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
    private String document;

    public User() {
        counter++;
    }

    public User(Integer ID, String name, String surname, Date birthday, String address, String document) {
        counter++;
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.document = document;
    }

    public User(String name, String surname, Date birthday, String address, String document) {
        this.ID = ++counter;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.document = document;
    }

    public static void getData(Path usersFile, Set userSet) {
        try (Scanner scanner = new Scanner(usersFile)) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                Scanner lineScanner = new Scanner(scanner.nextLine());
                lineScanner.useDelimiter(";");

                Integer ID = Integer.parseInt(lineScanner.next());
                String name = lineScanner.next();
                String surname = lineScanner.next();

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date birthday = simpleDateFormat.parse(lineScanner.next());

                String address = lineScanner.next();
                String document = lineScanner.next();

                User user = new User(ID, name, surname, birthday, address, document);

                userSet.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAll(Integer ID, String name, String surname, Date birthday, String address, String document) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.document = document;
    }

    @Override
    public String toString() {
        return String.format("ID: %d%nNome: %s%nCognome: %s%nData di nascita: %td/%tm/%tY%nIndirizzo: %s%nDocumento: %s%n", this.ID, this.name, this.surname, this.birthday, this.birthday, this.birthday, this.address, this.document);
    }
}*/
