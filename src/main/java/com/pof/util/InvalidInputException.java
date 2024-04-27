package com.pof.util;

public class InvalidInputException extends RuntimeException {

        public InvalidInputException(String message) {
            super(message + " Riprova.");
        }

}
