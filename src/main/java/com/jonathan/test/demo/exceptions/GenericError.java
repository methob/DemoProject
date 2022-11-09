package com.jonathan.test.demo.exceptions;

public class GenericError {
    private String message;
    private String message2;

    public GenericError(String message, String message2) {
        this.message = message;
        this.message2 = message2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
}
