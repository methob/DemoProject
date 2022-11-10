package com.jonathan.test.demo.exceptions;

public class CategoryAlreadyExistException extends RuntimeException {

    public CategoryAlreadyExistException(String message) {
        super(message);
    }
}
