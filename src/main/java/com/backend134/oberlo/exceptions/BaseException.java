package com.backend134.oberlo.exceptions;

public class BaseException extends RuntimeException {
    public BaseException() {

    }
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.errorMessage());
    }
}
