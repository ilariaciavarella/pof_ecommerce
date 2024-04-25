package com.pof.service;

import com.pof.model.*;
import com.pof.util.FileManager;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static com.pof.util.DataFormatter.*;

public class Service {
    private static Service service;
    private static final InputService inputService = InputService.getInstance();

    protected Set<Product> productSet;
    protected Set<User> userSet;
    protected Set<Sale> saleSet;

    private final Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
    private final Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
    private final Path salesFile = Paths.get("./src/main/java/assets/vendite.csv");

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
        System.out.printf("| %3s | %-24s | %11s | %8s | %-12s | %-15s |%n", "ID",
                "NOME", "INSERITO IL", "PREZZO", "MARCA", "DISPONIBILE");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        for (Product product : productSet) {
            System.out.println(product.toTable());
        }
    }

    // Set modifiers
    public void addSale(Integer[] saleData) {
        Sale sale = new Sale(saleData[0], saleData[1]);
        saleSet.add(sale);
        findProductById(saleData[0]).toggleAvailability();
    }

    public void removeSale(Integer saleId) {
        Integer productId = findSaleById(saleId).getProductId();
        saleSet.removeIf(sale -> sale.getSaleId() == saleId);
        findProductById(productId).toggleAvailability();
    }

    public void addUser(String[] userData) {
        User user = new User(userData);
        userSet.add(user);
        System.out.printf("Il tuo utente è stato correttamente registrato con ID: %d%n", user.getId());
    }

    // Export
    public void exportAvailableProducts() {
        Path availableProductsFile = Paths.get("./POF-Available_Products.txt");
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