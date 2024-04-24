package com.pof.util;

import com.pof.model.Product;
import com.pof.model.Sale;
import com.pof.model.User;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;

public class FileManager {
    private final Path productsFile;
    private final Path usersFile;
    private final Path salesFile;

    public FileManager(Path productsFile, Path usersFile, Path salesFile) {
        this.productsFile = productsFile;
        this.usersFile = usersFile;
        this.salesFile = salesFile;
    }

    // METHODS
    public <T> void readData(Path file, Set<T> set, Function<String[], T> mapper) {
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

    public void loadAllData(Set<Product> productSet, Set<User> userSet, Set<Sale> saleSet) {
        readData(productsFile, productSet, Product::new);
        readData(usersFile, userSet, User::new);
        readData(salesFile, saleSet, Sale::new);
    }
}
