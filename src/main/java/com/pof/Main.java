package com.pof;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Planty of Food!");

        Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
        Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
        Path sellsFile = Paths.get("./src/main/java/assets/vendite.csv");

        try (Scanner scanner = new Scanner(usersFile)) {
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}