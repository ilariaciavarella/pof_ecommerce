package com.pof.controller;

import com.pof.exceptions.FailedOperationException;
import com.pof.model.*;
import com.pof.service.*;
import com.pof.exceptions.InvalidInputException;

import java.util.*;
import java.util.function.Function;

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
            userOperation = Integer.parseInt(askForData(operationScanner, inputService::verifyOperation));

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

    public void displaySuccessMessage(String... extra) {
        System.out.println("\nL'operazione è stata effettuata con successo.");
        for (String s : extra) {
            System.out.println(s);
        }
    }

    public void handleOperation(Integer userOperation) {
        Scanner dataScanner = new Scanner(System.in);
        try {
            switch (userOperation) {
                case 1:
                    this.service.printProductsTable();
                    break;
                case 2:
                    System.out.println("Per acquistare un prodotto devi possedere un account: hai già creato il tuo? (Indica S o N)");
                    String answer = askForData(dataScanner, inputService::verifySN);
                    if (answer.equalsIgnoreCase("S")) {
                        this.service.addSale(getProductToBuy(dataScanner));
                        displaySuccessMessage();
                    } else {
                        System.out.println("Crea prima il tuo account digitando '4'.");
                        return;
                    }
                    break;
                case 3:
                    this.service.removeSale(getSaleToCancel(dataScanner));
                    displaySuccessMessage();
                    break;
                case 4:
                    this.service.addUser(getUserData(dataScanner));
                    displaySuccessMessage();
                    break;
                case 5:
                    this.service.exportAvailableProducts();
                    displaySuccessMessage("Controlla nella cartella 'pof_ecommerce'!");
                    break;
                case 0:
                    dataScanner.close();
                    System.out.println("Grazie per averci scelto. A presto!");
                    break;
                default:
                    System.out.println("L'operazione inserita non è valida.");
                    System.out.println("Per favore, scegli una tra le opzioni proposte.");
                    break;
            }
        } catch (NoSuchElementException | NullPointerException e) {
            System.out.println("Nessun elemento trovato");
        } catch (FailedOperationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ops! Qualcosa è andato storto. Riprova.");
        }
    }

    public String[] getProductToBuy(Scanner dataScanner) {
        System.out.printf("La nuova vendita sarà registrata con il seguente ID: %d%n", Sale.getNextId());
        String[] salesFields = new String[2];
        System.out.println("Inserisci l'ID del prodotto da acquistare:");
        salesFields[0] = askForData(dataScanner, inputService::verifyProductId);
        System.out.println("Ottimo! Ora inserisci il tuo ID utente:");
        salesFields[1] = askForData(dataScanner, inputService::verifyUserId);
        System.out.printf("La vendita è stata registrata con il seguente ID: %d%n", Sale.getNextId());
        return salesFields;
    }

    public Integer getSaleToCancel(Scanner dataScanner) {
        System.out.println("Inserisci l'ID della vendita da annullare:");
        String saleId = askForData(dataScanner, inputService::verifySaleId);
        return Integer.parseInt(saleId);
    }

    public String[] getUserData(Scanner dataScanner) {
        System.out.printf("Il nuovo utente sarà registrato con il seguente ID: %d%n", User.getNextId());
        String[] userData = new String[6];
        userData[0] = String.valueOf(User.getNextId());
        System.out.println("Inserisci il tuo nome:");
        userData[1] = askForData(dataScanner, inputService::verifyNames);
        System.out.println("Ora il tuo cognome:");
        userData[2] = askForData(dataScanner, inputService::verifyNames);
        System.out.println("Indica la tua data di nascita nel seguente formato: dd/mm/yyyy");
        userData[3] = askForData(dataScanner, inputService::verifyDate);
        System.out.println("Inserisci il tuo indirizzo completo (via, città):");
        userData[4] = askForData(dataScanner, inputService::verifyAddress);
        System.out.println("Inserisci il tuo documento di identità:");
        userData[5] = askForData(dataScanner, inputService::verifyDocument);
        System.out.printf("L'utente è stato registrato con il seguente ID: %d%n", User.getNextId());
        return userData;
    }

    public String askForData(Scanner dataScanner, Function<String, Boolean> verifier) {
        String line;
        Boolean lineValidity;
        do {
            line = dataScanner.nextLine();
            try {
                lineValidity = verifier.apply(line);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                lineValidity = false;
            }
        } while (!lineValidity);
        return line;
    }
}