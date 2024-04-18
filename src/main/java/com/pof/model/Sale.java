/*
package com.pof.model;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import com.pof.model.*;
import java.text.*;

public class Sale {
    private static int counter = 0;

    private Integer ID;
    private Integer productID;
    private Integer userID;

    public Sale() {
        counter++;
    }

    public Sale(Integer ID, Integer productID, Integer userID) {
        counter++;
        this.ID = ID;
        this.productID = productID;
        this.userID = userID;
    }

    public Sale(int productID, int userID) {
        this.ID = ++counter;
        this.productID = productID;
        this.userID = userID;
    }

    public static int getCounter() {
        return counter;
    }

    public static void getData(Path salesFile, Set saleSet) {
        try (Scanner scanner = new Scanner(salesFile)) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                Scanner lineScanner = new Scanner(scanner.nextLine());
                lineScanner.useDelimiter(";");

                Integer ID = Integer.parseInt(lineScanner.next());
                Integer productID = Integer.parseInt(lineScanner.next());
                Integer userID = Integer.parseInt(lineScanner.next());

                Sale sale = new Sale(ID, productID, userID);

                saleSet.add(sale);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAll(Integer ID, Integer productID, Integer userID) {
        this.ID = ID;
        this.productID = productID;
        this.userID = userID;
    }
}*/
