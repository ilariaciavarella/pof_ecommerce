package com.pof.service;

import com.pof.model.*;
import java.util.*;
import java.nio.file.*;

public class Service {
    private static Service service;

    private Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
    private Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
    private Path salesFile = Paths.get("./src/main/java/assets/vendite.csv");

    private Set<Product> productSet = new LinkedHashSet<Product>();
    private Set<User> userSet = new LinkedHashSet<User>();
    private Set<Sale> saleSet = new LinkedHashSet<Sale>();

    private Service() {
        Product.getData(productsFile, productSet);
        User.getData(usersFile, userSet);
        Sale.getData(salesFile, saleSet);
    };

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }

    public void printSet(Set set) {
        for (Object o : set) {
            System.out.println(o.toString());
        }
    }

    public void getOperation(int input) {
        switch(input) {
            case 1:
                System.out.println("Visualizza tutti i prodotti");
                this.printSet(productSet);
                break;
            case 2:
                System.out.println("Acquista un prodotto esistente");
                break;
            case 3:
                System.out.println("Restituisci un prodotto");
                break;
            case 4:
                System.out.println("Aggiungi un nuovo utente");
                break;
            case 5:
                System.out.println("Esporta un file con i prodotti disponibili");
                break;
            case 0:
                System.out.println("Esci dal programma");
                break;
            default:
                System.out.print("L'operazione inserita non è valida.\nPer favore, scegli una tra le opzioni proposte.\n\n");
                break;
        }
    }
}