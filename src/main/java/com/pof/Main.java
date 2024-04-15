package com.pof;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import com.pof.model.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Planty of Food!");

        Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
        Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
        Path sellsFile = Paths.get("./src/main/java/assets/vendite.csv");

        Set<Product> productSet = new LinkedHashSet<Product>();

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

        productSet.forEach(product -> {
            System.out.println(product.toString());
        });
    }
}