package com.pof.exceptions;

public class FailedOperationException extends RuntimeException {
    public FailedOperationException() {
        super("L'operazione non è andata a buon termine. Riprova.");
    }
}
