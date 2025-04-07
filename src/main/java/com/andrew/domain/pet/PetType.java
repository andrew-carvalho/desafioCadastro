package com.andrew.domain.pet;

public enum PetType {
    DOG("Cachorro"),
    CAT("Gato");

    private final String value;

    PetType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
