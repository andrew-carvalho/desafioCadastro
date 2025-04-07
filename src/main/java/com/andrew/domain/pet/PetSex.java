package com.andrew.domain.pet;

public enum PetSex {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String value;

    PetSex(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
