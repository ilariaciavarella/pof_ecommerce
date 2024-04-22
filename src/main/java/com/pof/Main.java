package com.pof;

import com.pof.model.FileManager;
import com.pof.model.User;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto su Planty of Food!");

        FileManager fileManager = new FileManager();
        fileManager.loadData();

        Scanner operationScanner = new Scanner(System.in);
        int userInput = 0;

        do {
            System.out.println("Come possiamo aiutarti?");
            System.out.println("1. Visualizza tutti i prodotti");
            System.out.println("2. Acquista un prodotto esistente");
            System.out.println("3. Restituisci un prodotto");
            System.out.println("4. Aggiungi un nuovo utente");
            System.out.println("5. Esporta un file con i prodotti disponibili");
            System.out.println("0. Esci dal programma");
            System.out.println("\nScegli un'operazione:");
            userInput = operationScanner.nextInt();
            Scanner dataScanner = new Scanner(System.in);

            switch(userInput) {
                case 1:
                    fileManager.getProductsTable();
                    break;
                case 2:
                    System.out.println("Scegli il prodotto da acquistare:");
                    int productId = dataScanner.nextInt();

                    System.out.println("\nPerfetto! Ora inserisci il tuo ID utente:");
                    int userId = dataScanner.nextInt();

                    System.out.println("\nGrazie! La vendita è stata aggiunta correttamente.\n");
                    break;
                case 3:
                    System.out.println("Indica la vendita da annullare:");
                    int saleId = dataScanner.nextInt();

                    System.out.println("\nIl prodotto è stato restituito come da tua richiesta.\n");
                    break;
                case 4:
                    System.out.println("Il nuovo utente sarà registrato con il seguente ID: 4");
                    System.out.println("Per favore, inserisci il tuo nome:");
                    String name = dataScanner.nextLine();

                    System.out.println("\nOra il tuo cognome:");
                    String surname = dataScanner.nextLine();

                    System.out.println("\nIndica la tua data di nascita nel seguente formato: dd/mm/yyyy");
                    Date birthdate = FileManager.formatDate(dataScanner.nextLine());

                    System.out.println("\nInserisci il tuo indirizzo completo per la spedizione:");
                    String address = dataScanner.nextLine();

                    System.out.println("\nCi siamo quasi. Inserisci il documento di identità:");
                    String document = dataScanner.nextLine();

                    User user = new User(4, name, surname, birthdate, address, document);
                    System.out.println(user.toString());
                    System.out.println("\nGrazie! Il nuovo utente è stato aggiunto con successo!\n");
                    break;
                case 5:
                    System.out.println("Esporta un file con i prodotti disponibili");
                    break;
                case 0:
                    System.out.println("Grazie per averci scelto. A presto!");
                    break;
                default:
                    System.out.println("L'operazione inserita non è valida.");
                    System.out.println("Per favore, scegli una tra le opzioni proposte.\n");
                    break;
            }
        } while ( userInput != 0 );

    }

}