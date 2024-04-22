package com.pof.model;

import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;

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

    // METODS
    // Formatters
    public static Integer formatId(String stringId) {
        return Integer.parseInt(stringId);
    }

    public static Date formatDate(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(stringDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Double formatPrice(String stringPrice) {
        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        try {
            return nf.parse(stringPrice).doubleValue();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Loaders
    public void loadData() {
        try (BufferedReader reader = Files.newBufferedReader(productsFile)) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                loadProducts(data);
            }

        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader reader = Files.newBufferedReader(usersFile)) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                loadUsers(data);
            }

        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader reader = Files.newBufferedReader(salesFile)) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                loadSales(data);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Loaded products: " + productSet.size());
        System.out.println("Loaded users: " + userSet.size());
        System.out.println("Loaded sales: " + saleSet.size());
    }

    public void loadProducts (String[] productFields) throws ParseException {
        if (productFields.length == 6) {
            Integer id = formatId(productFields[0]);
            String name = productFields[1];
            Date insertDate = formatDate(productFields[2]);
            Double price = formatPrice(productFields[3]);
            String brand = productFields[4];
            Boolean availability = productFields[5].equalsIgnoreCase("SI");

            Product product = new Product(id, name, insertDate, price, brand, availability);
            productSet.add(product);
        } else {
            System.out.println("Questo prodotto non è valido");
        }
    }

    public void loadUsers(String[] userFields) throws ParseException {
        if (userFields.length == 6) {
            Integer id = formatId(userFields[0]);
            String name = userFields[1];
            String surname = userFields[2];
            Date birthdate = formatDate(userFields[3]);
            String address = userFields[4];
            String document = userFields[5];

            User user = new User(id, name, surname, birthdate, address, document);
            userSet.add(user);
        } else {
            System.out.println("Questo utente non è valido");
        }
    }

    public void loadSales(String[] saleFields) {
        if (saleFields.length == 3) {
            Integer saleId = formatId(saleFields[0]);
            Integer productId = formatId(saleFields[1]);
            Integer userId = formatId(saleFields[2]);

            Sale sale = new Sale(saleId, productId, userId);
            saleSet.add(sale);
        } else {
            System.out.println("Questa vendita non è valida");
        }
    }

    // Getters
    public void getProductsTable() {
        System.out.printf("Planty of Foods - Lista prodotti %n");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| %3s | %-24s | %11s | %8s | %-10s | %-11s |%n", "ID",
                "NOME", "INSERITO IL", "PREZZO", "MARCA", "DISPONIBILE");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        for (Product product : productSet) {
            System.out.printf("| %3d | %-24s |  %td/%tm/%tY | € %6.2f | %-10s | %-11b |%n", product.getId(),
                    product.getName(), product.getInsertDate(), product.getInsertDate(), product.getInsertDate(),
                    product.getPrice(), product.getBrand(), product.getAvailability());
        }
    }

}
