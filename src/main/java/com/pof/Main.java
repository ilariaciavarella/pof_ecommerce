package com.pof;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.text.*;
import com.pof.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Planty of Food!");

        Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
        Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
        Path salesFile = Paths.get("./src/main/java/assets/vendite.csv");

        Set<Product> productSet = new LinkedHashSet<Product>();
        Set<User> userSet = new LinkedHashSet<User>();
        Set<Sale> saleSet = new LinkedHashSet<Sale>();

        Product.getData(productsFile, productSet);
        User.getData(usersFile, userSet);
        Sale.getData(salesFile, saleSet);


    }
}