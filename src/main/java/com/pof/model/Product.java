/*
package com.pof.model;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import com.pof.model.*;
import java.text.*;

public class Product {
    private static int counter = 0;

    private Integer ID;
    private String name;
    private Date insertDate;
    private Double price;
    private String brand;
    private Boolean availability;

    public Product() {
        counter++;
    }

    public Product(Integer ID, String name, Date insertDate, Double price, String brand, Boolean availability) {
        counter++;
        this.ID = ID;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price;
        this.brand = brand;
        this.availability = availability;
    }

    public Product(String name, Date insertDate, Double price, String brand, Boolean availability) {
        this.ID = ++counter;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price;
        this.brand = brand;
        this.availability = availability;
    }

    public static void getData(Path productsFile, Set productSet) {
        try (Scanner scanner = new Scanner(productsFile)) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                Scanner lineScanner = new Scanner(scanner.nextLine());
                lineScanner.useDelimiter(";");

                Integer ID = Integer.parseInt(lineScanner.next());
                String name = lineScanner.next();

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date insertDate = simpleDateFormat.parse(lineScanner.next());

                NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
                Double price = nf.parse(lineScanner.next()).doubleValue();
                String brand = lineScanner.next();
                Boolean available = (lineScanner.next().equalsIgnoreCase("NO")) ? false : true;

                Product product = new Product(ID, name, insertDate, price, brand, available);

                productSet.add(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAll(Integer ID, String name, Date insertDate, Double price, String brand, Boolean availability) {
        this.ID = ID;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price;
        this.brand = brand;
        this.availability = availability;
    }

    public void printName() {
        System.out.printf("%d - %s%n", this.ID, this.name);
    }

    public Boolean getAvailability() {
        return this.availability;
    }

    @Override
    public String toString() {
        return String.format("ID: %d%nNome: %s%nData di inserimento: %td/%tm/%tY%nPrezzo: €%.2f%nMarca: %s%nDisponibile: %b%n", this.ID, this.name, this.insertDate, this.insertDate, this.insertDate, this.price, this.brand, this.availability);
    }
}*/
