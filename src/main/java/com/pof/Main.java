package com.pof;

import com.pof.model.*;
import com.pof.controller.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto su Planty of Food!");

        /*Path productsFile = Paths.get("./src/main/java/assets/prodotti.csv");
        Path usersFile = Paths.get("./src/main/java/assets/utenti.csv");
        Path salesFile = Paths.get("./src/main/java/assets/vendite.csv");

        Set<Product> productSet = new LinkedHashSet<Product>();
        Set<User> userSet = new LinkedHashSet<User>();
        Set<Sale> saleSet = new LinkedHashSet<Sale>();

        Product.getData(productsFile, productSet);
        User.getData(usersFile, userSet);
        Sale.getData(salesFile, saleSet);*/

        Controller controller = new Controller();

        controller.start();
    }
}