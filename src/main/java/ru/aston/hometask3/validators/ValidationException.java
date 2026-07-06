package ru.aston.hometask3.validators;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
