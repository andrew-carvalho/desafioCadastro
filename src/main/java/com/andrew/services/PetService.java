package com.andrew.services;

import com.andrew.domain.address.Address;
import com.andrew.domain.pet.InvalidPetException;
import com.andrew.domain.pet.PetSex;
import com.andrew.domain.pet.PetType;

public class PetService {

    public static String NOT_INFORMED = "NÃO INFORMADO";

    public static void validatePetName(String petName) {
        if (petName.isEmpty()) {
            throw new InvalidPetException("Obrigatório preencher nome e sobrenome!");
        }

        if (!petName.matches("^[a-zA-Z ]+$")) {
            throw new InvalidPetException("Nome e sobrenome só pode conter letras de A à Z!");
        }
    }

    public static PetType validatePetType(String petTypeString) {
        if (petTypeString.equalsIgnoreCase("CACHORRO")) {
            return PetType.DOG;
        } else if (petTypeString.equalsIgnoreCase("GATO")) {
            return PetType.CAT;
        } else {
            throw new InvalidPetException("Tipo de pet inválido!");
        }
    }

    public static PetSex validatePetSex(String petSexString) {
        if (petSexString.equalsIgnoreCase("M")) {
            return PetSex.MALE;
        } else if (petSexString.equalsIgnoreCase("F")) {
            return PetSex.FEMALE;
        } else {
            throw new InvalidPetException("Sexo do pet inválido!");
        }
    }

    public static Address createAddress(String houseNumber, String cityName, String streetName) {
        if (houseNumber.isEmpty()) {
            houseNumber = NOT_INFORMED;
        }

        return new Address(houseNumber, cityName, streetName);
    }

    public static String validatePetAge(String petAge) {
        String petAgeDummy = petAge.replace(",", ".");
        String petAgeWithoutSeparator = petAgeDummy.replace(".", "");

        if (petAgeWithoutSeparator.isEmpty()) {
            return NOT_INFORMED;
        }

        if (!petAgeWithoutSeparator.matches("^\\d+$")) {
            throw new InvalidPetException("A idade do pet só pode conter números!");
        }

        double petAgeDoubleValue = Double.parseDouble(petAge);

        if (petAgeDoubleValue > 20) {
            throw new InvalidPetException("Idade inválida! Não pode ser maior que 20 anos.");
        }

        if (petAgeDoubleValue < 0) {
            return petAge + " anos";
        }

        return petAge;
    }

    public static String validatePetWeight(String petWeight) {
        String petWeightDummy = petWeight.replace(",", ".");
        String petWeightWithoutSeparator = petWeightDummy.replace(".", "");

        if (petWeightWithoutSeparator.isEmpty()) {
            return NOT_INFORMED;
        }

        if (!petWeightWithoutSeparator.matches("^\\d+$")) {
            throw new InvalidPetException("A idade do pet só pode conter números!");
        }

        double petWeightDoubleValue = Double.parseDouble(petWeightDummy);

        if (petWeightDoubleValue > 60 || petWeightDoubleValue < 0.5) {
            throw new InvalidPetException("Peso inválido! Intervalo permitido é de 0.5 kg à 60.0 kg");
        }

        return petWeight;
    }

    public static void validatePetRace(String petRace) {
        if (petRace.isEmpty()) {
            petRace = NOT_INFORMED;
        }

        if (!petRace.matches("^[a-zA-Z ]+$")) {
            throw new InvalidPetException("Nome e sobrenome só pode conter letras de A à Z!");
        }
    }

}
