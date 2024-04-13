package com.pof;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Planty of Food!");

        try {
            InputStream input = new FileInputStream("./src/main/java/assets/prodotti.csv");
            System.out.println("Data in the file: ");

            int i = input.read();

            while(i != -1) {
                System.out.print((char)i);

                i = input.read();
            }
            input.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}