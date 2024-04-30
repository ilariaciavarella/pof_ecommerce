package com.pof.service;

import static com.pof.util.DataFormatter.*;

import com.pof.exceptions.InvalidInputException;

public class InputService {
    private static InputService inputService;
    private static final Service service = Service.getInstance();

    private InputService() {
    }

    public static InputService getInstance() {
        if (inputService == null) {
            inputService = new InputService();
        }
        return inputService;
    }

    // Verify operation
    public Boolean verifyOperation(String userOp) {
        String regex = "^[0-9]+$";
        if( userOp.matches(regex)) {
            return true;
        } else {
            throw new InvalidInputException("La tua scelta deve essere un numero valido.");
        }
    }

    // Verify ID
    public Boolean verifyProductId(String productIdString) {
        Integer productId = formatId(productIdString);
        if (productId > 0
                && service.findProductById(productId) != null
                && service.findProductById(productId).getAvailability()) {
            return true;
        } else {
            throw new InvalidInputException("L'ID Prodotto che hai inserito non è valido.");
        }
    }

    public Boolean verifyUserId(String userIdString) {
        Integer userId = formatId(userIdString);
        if (userId > 0
                && service.findUserById(userId) != null) {
            return true;
        } else {
            throw new InvalidInputException("L'ID utente che hai inserito non è valido.");
        }
    }

    public Boolean verifySaleId(String saleIdString) {
        Integer saleId = formatId(saleIdString);
        if (saleId > 0
                && service.findSaleById(saleId) != null) {
            return true;
        } else {
            throw new InvalidInputException("L'ID vendita che hai inserito non è valido.");
        }
    }

    // Verify names
    public Boolean verifyNames(String name) {
        String regex = "^[a-zA-Z'\\s]+$";

        if (name.length() > 1
                && name.matches(regex)) {
            return true;
        } else {
            throw new InvalidInputException("Il nome inserito non è valido.");
        }
    }

    // Verify date
    public Boolean verifyDate(String date) {
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        Integer year = Integer.parseInt(date.substring(6));

        if (date.matches(regex) &&  year >= 1900 && year <= 2008) {
            return true;
        } else {
            throw new InvalidInputException("La data che hai inserito non è valida.");
        }
    }

    // Verify address
    public Boolean verifyAddress(String address) {
        String regex = "[\\w\\s',.]+";

        if (address.length() > 3
                && address.split(" ").length > 3
                && address.matches(regex)) {
            return true;
        } else {
            throw new InvalidInputException("L'indirizzo che hai inserito non è valido.");
        }
    }

    // Verify document
    public Boolean verifyDocument(String document) {
        String regex = "^[a-zA-Z0-9\\s]+$";

        if (document.length() > 7
                && document.matches(regex)) {
            return true;
        } else {
            throw new InvalidInputException("Il tuo documento non è valido.");
        }
    }

    // Verify yes or no
    public Boolean verifySN (String answer) {
        if (answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("N")) {
            return true;
        } else {
            throw new InvalidInputException("La tua risposta non è valida.");
        }
    }
}
