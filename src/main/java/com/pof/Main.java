package com.pof;

import com.pof.controller.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto su Planty of Food!");

        Controller controller = new Controller();
        controller.start();
    }
}