package com.pof.service;

import com.pof.exceptions.FailedOperationException;
import com.pof.model.*;
import com.pof.util.FileManager;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static com.pof.util.DataFormatter.*;

public class Service {
    private static Service service;

    protected Set<Product> productSet;
    protected Set<User> userSet;
    protected Set<Sale> saleSet;

    private final String productsFile = "/prodotti.csv";
    private final String usersFile = "/utenti.csv";
    private final String salesFile = "/vendite.csv";

    private final FileManager csvManager = new FileManager(productsFile, usersFile, salesFile);

    private Service() {
        productSet = new LinkedHashSet<>();
        userSet = new LinkedHashSet<>();
        saleSet = new LinkedHashSet<>();
        csvManager.loadAllData(productSet, userSet, saleSet);
    }

    public static Service getInstance() {
        if(service == null) {
            service = new Service();
        }
        return service;
    }

    // Printer
    public void printProductsTable() {
        System.out.printf("Planty of Foods - Lista prodotti %n");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %3s | %-24s | %-11s | %-8s | %-12s | %-15s |%n", "ID",
                "NOME", "INSERITO IL", "PREZZO", "MARCA", "DISPONIBILITÀ");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        for (Product product : productSet) {
            System.out.println(product.toTable());
        }
    }

    // Set modifiers
    public void addSale(String[] saleData) {
        try {
            Sale sale = new Sale(formatId(saleData[0]), formatId(saleData[1]));
            saleSet.add(sale);
            findProductById(formatId(saleData[0])).toggleAvailability();
        } catch (Exception e) {
            throw new FailedOperationException();
        }
    }

    public void removeSale(Integer saleId) {
        try {
            Integer productId = findSaleById(saleId).getProductId();
            saleSet.removeIf(sale -> sale.getSaleId() == saleId);
            findProductById(productId).toggleAvailability();
        } catch (Exception e) {
            throw new FailedOperationException();
        }
    }

    public void addUser(String[] userData) {
        try {
            User user = new User(userData);
            userSet.add(user);
        } catch (Exception e) {
            throw new FailedOperationException();
        }
    }

    // Export
    public void exportAvailableProducts() {
        Calendar today = Calendar.getInstance();
        String fileName = String.format("./POF-Available_Products-%td_%tm_%tY.txt", today, today, today);
        Path availableProductsFile = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(availableProductsFile)) {
            for (Product product : productSet) {
                if (product.getAvailability()) {
                    writer.write(product.toString(), 0, product.toString().length());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Finder
    public Product findProductById(Integer productId) {
        for (Product product : productSet) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public Sale findSaleById(Integer saleId) {
        for (Sale sale : saleSet) {
            if (sale.getSaleId() == saleId) {
                return sale;
            }
        }
        return null;
    }

    public User findUserById(Integer userId) {
        for (User user : userSet) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }
}