package com.pof.util;

import com.pof.model.*;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class FileManager {
    private final String productsFile;
    private final String usersFile;
    private final String salesFile;

    public FileManager(String productsFile, String usersFile, String salesFile) {
        this.productsFile = productsFile;
        this.usersFile = usersFile;
        this.salesFile = salesFile;
    }

    // METHODS
    public static InputStream getFilesStream(String file) {
        return FileManager.class.getResourceAsStream(file);
    }

    public <T> void readData(String file, Set<T> set, Function<String[], T> mapper) {
        InputStream fileStream = getFilesStream(file);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream))) {
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
