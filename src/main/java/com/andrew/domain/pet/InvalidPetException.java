package com.andrew.domain.pet;

public class InvalidPetException extends RuntimeException {
    public InvalidPetException(String message) {
        super(message);
    }
}
