package com.pof.exceptions;

public class InvalidInputException extends RuntimeException {

        public InvalidInputException(String message) {
            super(message + " Riprova.");
        }

}
