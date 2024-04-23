package com.pof.util;

import com.pof.model.Product;
import com.pof.model.Sale;
import com.pof.model.User;

import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import java.util.function.Function;

public class FileManager {
    private Set<Product> productSet;
    private Set<User> userSet;
    private Set<Sale> saleSet;

    private final Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
    private final Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
    private final Path salesFile = Paths.get("./src/main/java/assets/vendite.csv");

    public FileManager() {
        this.productSet = new LinkedHashSet<>();
        this.userSet = new LinkedHashSet<>();
        this.saleSet = new LinkedHashSet<>();
    }

    // METHODS
    // Loaders
    public static <T> void readData(Path file, Set<T> set, Function<String[], T> mapper) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String[] fields = reader.readLine().split(";");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length == fields.length) {

                    T item = mapper.apply(data);
                    set.add(item);

                } else {
                    System.out.println("Questo elemento non è valido");
                }
            }
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }

    public void loadAllData() {
        readData(productsFile, productSet, Product::new);
        readData(usersFile, userSet, User::new);
        readData(salesFile, saleSet, Sale::new);
    }

    // Getters
    public void getProductsTable() {
        System.out.printf("Planty of Foods - Lista prodotti %n");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| %3s | %-24s | %11s | %8s | %-10s | %-15s |%n", "ID",
                "NOME", "INSERITO IL", "PREZZO", "MARCA", "DISPONIBILE");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        for (Product product : productSet) {
            System.out.printf("| %3d | %-24s |  %td/%tm/%tY | € %6.2f | %-10s | %-15s |%n",
                    product.getId(), product.getName(), product.getInsertDate(), product.getInsertDate(),
                    product.getInsertDate(), product.getPrice(), product.getBrand(), product.getStringAvailability());
        }
    }

    public void getSalesTable() {
        System.out.printf("Planty of Foods - Lista vendite %n");
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %10s | %11s | %9s |%n", "ID VENDITA",
                "ID PRODOTTO", "ID UTENTE");
        System.out.printf("------------------------------------------%n");
        for (Sale sale : saleSet) {
            System.out.printf("| %-10d | %-11d |  %-9d |%n",
                    sale.getSaleId(), sale.getProductId(), sale.getUserId());
        }
    }

    public void getUsersTable() {
        System.out.printf("Planty of Foods - Lista utenti %n");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| %3s | %-18s | %18s | %10s | %-30s | %-11s |%n", "ID",
                "NOME", "COGNOME", "NAT* IL", "INDIRIZZO", "DOCUMENTO");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        for (User user : userSet) {
            System.out.printf("| %3s | %-18s | %18s |  %td/%tm/%tY | %-30s | %-11s |%n",
                    user.getId(), user.getName(), user.getSurname(), user.getBirthdate(), user.getBirthdate(),
                    user.getBirthdate(), user.getAddress(), user.getDocument());
        }
    }

    // Set modifiers
    public void addSale(Sale sale) {
        saleSet.add(sale);
    }

    public void removeSale(Integer saleId) {
        saleSet.removeIf(sale -> sale.getSaleId() == saleId);
    }

    public void addUser(User user) {
        userSet.add(user);
    }

    // Export
    public void exportAvailableProducts() {
        Path availableProductsFile = Paths.get("./POF-Available_Products.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(availableProductsFile)) {
            for (Product product : productSet) {
                if (product.getAvailability()) {
                    String s = String.format("ID: %d%nNome: %s%nInserito il: %td/%tm/%tY%nPrezzo: € %.2f%nBrand: %s%n%n",
                            product.getId(), product.getName(), product.getInsertDate(), product.getInsertDate(),
                            product.getInsertDate(), product.getPrice(), product.getBrand());
                    writer.write(s, 0, s.length());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
