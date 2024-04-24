package com.pof.service;

import com.pof.model.*;
import com.pof.util.FileManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static com.pof.util.DataFormatter.*;

public class Service {
    private static Service service;

    private Set<Product> productSet;
    private Set<User> userSet;
    private Set<Sale> saleSet;

    private final Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
    private final Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
    private final Path salesFile = Paths.get("./src/main/java/assets/vendite.csv");

    private final FileManager fileManager = new FileManager(productsFile, usersFile, salesFile);

    private Service() {
        productSet = new LinkedHashSet<>();
        userSet = new LinkedHashSet<>();
        saleSet = new LinkedHashSet<>();
        fileManager.loadAllData(productSet, userSet, saleSet);
    }

    public static Service getInstance() {
        if(service == null) {
            service = new Service();
        }
        return service;
    }

    // Getters
    public void getProductsTable() {
        System.out.printf("Planty of Foods - Lista prodotti %n");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %3s | %-24s | %11s | %8s | %-12s | %-15s |%n", "ID",
                "NOME", "INSERITO IL", "PREZZO", "MARCA", "DISPONIBILE");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        for (Product product : productSet) {
            System.out.println(product.toTable());
        }
    }

    // Set modifiers
    public void addSale(Sale sale) {
        saleSet.add(sale);
    }

    public void removeSale(Integer saleId) {
        saleSet.removeIf(sale -> sale.getSaleId() == saleId);
    }

    public void addUser(User user) {
        userSet.add(user);
    }

    // Export
    public void exportAvailableProducts() {
        Path availableProductsFile = Paths.get("./POF-Available_Products.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(availableProductsFile)) {
            for (Product product : productSet) {
                if (product.getAvailability()) {
                    writer.write(product.toString(), 0, product.toString().length());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getOperation(Integer userOperation) {
        Scanner dataScanner = new Scanner(System.in);
        switch(userOperation) {
            case 1:
                getProductsTable();
                break;
            case 2:
                System.out.println("Scegli il prodotto da acquistare:");
                int productId = dataScanner.nextInt();

                System.out.println("\nPerfetto! Ora inserisci il tuo ID utente:");
                int userId = dataScanner.nextInt();

                Sale sale = new Sale(productId, userId);
                addSale(sale);

                System.out.println("\nGrazie! La vendita è stata aggiunta correttamente.\n");
                break;
            case 3:
                System.out.println("Indica la vendita da annullare:");
                int saleId = dataScanner.nextInt();

                removeSale(saleId);

                System.out.println("\nIl prodotto è stato restituito come da tua richiesta.\n");
                break;
            case 4:
                System.out.printf("Il nuovo utente sarà registrato con il seguente ID: %d%n", User.getNextId());
                System.out.println("Per favore, inserisci il tuo nome:");
                String name = capitalise(dataScanner.nextLine());

                System.out.println("\nOra il tuo cognome:");
                String surname = capitalise(dataScanner.nextLine());

                System.out.println("\nIndica la tua data di nascita nel seguente formato: dd/mm/yyyy");
                Date birthdate = formatDate(dataScanner.nextLine());

                System.out.println("\nInserisci il tuo indirizzo completo per la spedizione:");
                String address = dataScanner.nextLine();

                System.out.println("\nCi siamo quasi. Inserisci il documento di identità:");
                String document = dataScanner.nextLine();

                User user = new User(User.getNextId(), name, surname, birthdate, address, document);
                addUser(user);

                System.out.println("\nGrazie! Il nuovo utente è stato aggiunto con successo!\n");
                break;
            case 5:
                exportAvailableProducts();
                break;
            case 0:
                System.out.println("Grazie per averci scelto. A presto!");
                break;
            default:
                System.out.println("L'operazione inserita non è valida.");
                System.out.println("Per favore, scegli una tra le opzioni proposte.\n");
                break;
        }
    }
}