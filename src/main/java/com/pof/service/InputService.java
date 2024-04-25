package com.pof.service;

import java.util.regex.*;

public class InputService {
    private static InputService inputService;
    private static final Service service = Service.getInstance();

    private InputService() {    }

    public static InputService getInstance() {
        if(inputService == null) {
            inputService = new InputService();
        }
        return inputService;
    }

    // Verify ID
    public Boolean verifyProductId(Integer productId) {
        return productId != null
                && productId > 0
                && service.findProductById(productId) != null
                && service.findProductById(productId).getAvailability();
    }

    public Boolean verifyUserId(Integer userId) {
        return userId != null
                && userId > 0
                && service.findUserById(userId) != null;
    }

    public Boolean verifySaleId(Integer saleId) {
        return saleId != null
                && saleId > 0
                && service.findSaleById(saleId) != null;
    }

    // Verify names
    public Boolean verifyNames(String name) {
        String regex = "^[a-zA-Z]+$";

        return name.length() > 1
                && name.matches(regex);
    }

    // Verify address
    public Boolean verifyAddress(String address) {
        String regex = "\\b[\\w']+\\s+[\\w']+\\s+\\d+,\\s+[\\w']+\\b";

        return address.length() > 3
                && address.split(" ").length > 4
                && address.matches(regex);
    }

    // Verify document
    public Boolean verifyDocument(String document) {
        String regex = "^[a-zA-Z0-9]+$";

        return document.length() > 8
                && document.matches(regex);
    }
}
