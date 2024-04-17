package com.pof.controller;

import com.pof.service.*;
import java.util.Scanner;

public class Controller {
    private Service service;

    public Controller() {
        this.service = Service.getInstance();
    }

    public void start() {
        Scanner inputScanner = new Scanner(System.in);
        int userInput = 0;

        do {
            printOptions();
            userInput = inputScanner.nextInt();
            this.service.getOperation(userInput);
        } while(userInput !=0);
    }

    private void printOptions() {
        System.out.println("Quale operazione vuoi compiere?");
        System.out.println("1. Visualizza tutti i prodotti");
        System.out.println("2. Acquista un prodotto esistente");
        System.out.println("3. Restituisci un prodotto");
        System.out.println("4. Aggiungi un nuovo utente");
        System.out.println("5. Esporta un file con i prodotti disponibili");
        System.out.println("0. Esci dal programma");
    }
}