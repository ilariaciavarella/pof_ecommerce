package com.pof.controller;

import com.pof.model.User;
import com.pof.service.InputService;
import com.pof.service.Service;

import java.util.*;

public class Controller {
    private final Service service;
    private final InputService inputService;

    public Controller() {
        this.service = Service.getInstance();
        this.inputService = InputService.getInstance();
    }

    public void start() {
        Scanner operationScanner = new Scanner(System.in);
        int userOperation;

        do {
            printOptions();
            userOperation = operationScanner.nextInt();

            handleOperation(userOperation);
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

    public String askUserData(String message) {
        Scanner dataScanner = new Scanner(System.in);
        System.out.println(message);
        return dataScanner.nextLine();
    }

    public void displaySuccessMessage() {
        System.out.println("\nL'operazione è stata effettuata con successo.");
    }

    public void handleOperation(Integer userOperation) {
        switch (userOperation) {
            case 1:
                this.service.printProductsTable();
                break;
            case 2:
                try {
                    this.service.addSale(getProductToBuy());
                    displaySuccessMessage();
                } catch (Exception e) {
                    System.out.println("Ops! Qualcosa è andato storto. Riprova.");
                }
                break;
            case 3:
                try {
                    this.service.removeSale(getSaleToCancel());
                    displaySuccessMessage();
                } catch (Exception e) {
                    System.out.println("Ops! Qualcosa è andato storto. Riprova.");
                }
                break;
            case 4:
                System.out.printf("Il nuovo utente sarà registrato con il seguente ID: %d%n", User.getNextId());
                String[] userData = new String[6];
                userData[0] = String.valueOf(User.getNextId());
                userData[1] = askUserData("Inserisci il tuo nome:");
                userData[2] = askUserData("\nOra il tuo cognome:");
                userData[3] = askUserData("\nIndica la tua data di nascita nel seguente formato: dd/mm/yyyy");
                userData[4] = askUserData("\nInserisci il tuo indirizzo completo:");
                userData[5] = askUserData("\nInserisci il tuo documento di identità:");
                this.service.addUser(userData);
                displaySuccessMessage();
                break;
            case 5:
                this.service.exportAvailableProducts();
                displaySuccessMessage();
                break;
            case 0:
                System.out.println("Grazie per averci scelto. A presto!");
                break;
            default:
                System.out.println("L'operazione inserita non è valida.");
                System.out.println("Per favore, scegli una tra le opzioni proposte.");
                break;
        }
    }

    public Integer[] getProductToBuy() {
        Integer[] salesFields = new Integer[2];
        Scanner dataScanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID del prodotto da acquistare:");
        salesFields[0] = dataScanner.nextInt();
        Boolean productValidity = inputService.verifyProductId(salesFields[0]);
        while (!productValidity) {
            System.out.println("L'ID che hai inserito sembra non essere valido. Riprova:");
            salesFields[0] = dataScanner.nextInt();
            productValidity = inputService.verifyProductId(salesFields[0]);
        };
        System.out.println("Ottimo! Ora inserisci il tuo ID utente:");
        salesFields[1] = dataScanner.nextInt();
        Boolean userValidity = inputService.verifyProductId(salesFields[1]);
        while (!userValidity) {
            System.out.println("L'ID che hai inserito sembra non essere valido. Riprova:");
            salesFields[1] = dataScanner.nextInt();
            userValidity = inputService.verifyProductId(salesFields[1]);
        };

        dataScanner.close();
        return salesFields;
    }

    public Integer getSaleToCancel() {
        Scanner dataScanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID della vendita da annullare:");
        Integer saleId = dataScanner.nextInt();
        Boolean saleValidity = inputService.verifySaleId(saleId);
        while (!saleValidity) {
            System.out.println("L'ID che hai inserito sembra non essere valido. Riprova:");
            saleId = dataScanner.nextInt();
            saleValidity = inputService.verifySaleId(saleId);
        }
        dataScanner.close();
        return saleId;
    }

    public String[] getUserData() {
        Scanner dataScanner = new Scanner(System.in);
        System.out.printf("Il nuovo utente sarà registrato con il seguente ID: %d%n", User.getNextId());
        String[] userData = new String[6];
        userData[0] = String.valueOf(User.getNextId());
        System.out.println("Inserisci il tuo nome:");
        userData[1] = dataScanner.nextLine();
        Boolean nameValidity = inputService.verifyNames(userData[1]);
        while (!nameValidity) {
            System.out.println("Il nome che hai inserito non è valido. Riprova:");
            userData[1] = dataScanner.nextLine();
            nameValidity = inputService.verifyNames(userData[1]);
        }
        System.out.println("Ora il tuo cognome:");
        Boolean surnameValidity = inputService.verifyNames(userData[1]);
        while (!surnameValidity) {
            System.out.println("Il cognome che hai inserito non è valido. Riprova:");
            userData[2] = dataScanner.nextLine();
            surnameValidity = inputService.verifyNames(userData[2]);
        }
        userData[2] = dataScanner.nextLine();
        System.out.println("Indica la tua data di nascita nel seguente formato: dd/mm/yyyy");
        userData[3] = dataScanner.nextLine();
        System.out.println("Inserisci il tuo indirizzo completo:");
        userData[4] = dataScanner.nextLine();
        System.out.println("Inserisci il tuo documento di identità:");
        userData[5] = dataScanner.nextLine();

        return userData;
    }
}