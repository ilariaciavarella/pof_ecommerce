package com.pof.controller;

import com.pof.service.Service;

import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller() {
        this.service = Service.getInstance();
    }

    public void start() {
        Scanner operationScanner = new Scanner(System.in);
        int userOperation;

        do {
            printOptions();
            userOperation = operationScanner.nextInt();

            this.service.getOperation(userOperation);
        } while (userOperation != 0);
    }

    public void printOptions() {
        System.out.println("\nCome possiamo aiutarti?");
        System.out.println("1. Visualizza tutti i prodotti");
        System.out.println("2. Acquista un prodotto esistente");
        System.out.println("3. Restituisci un prodotto");
        System.out.println("4. Aggiungi un nuovo utente");
        System.out.println("5. Esporta un file con i prodotti disponibili");
        System.out.println("0. Esci dal programma");
        System.out.println("\nScegli un'operazione:");
    }
}