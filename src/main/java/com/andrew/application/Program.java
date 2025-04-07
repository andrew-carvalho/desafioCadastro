package com.andrew.application;

import com.andrew.domain.address.Address;
import com.andrew.domain.pet.InvalidPetException;
import com.andrew.domain.pet.Pet;
import com.andrew.domain.pet.PetSex;
import com.andrew.domain.pet.PetType;
import com.andrew.services.PetService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        printFormulario();
        printMenu();
    }

    public static StringBuilder readFileContent(String path) {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                fileContent.append(fileLine).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro interno! " + e.getMessage());
        }

        return fileContent.delete(fileContent.length() - 1, fileContent.length());
    }

    public static void printFormulario() {
        StringBuilder fileContent = readFileContent("formulario.txt");
        System.out.println(fileContent);
        System.out.println();
    }

    public static void printMenu() {
        while (true) {
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int userInput = 0;

            try {
                userInput = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico! " + e.getMessage());
            }

            switch (userInput) {
                case 1:
                    createPet();
                    break;
                case 2:
                    // TODO: Alterar pet cadastrado
                    break;
                case 3:
                    // TODO: Remover pet cadastrado
                    break;
                case 4:
                    // TODO: Listar pets
                    break;
                case 5:
                    // TODO: Listar pets por critério
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida! tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    public static void createPet() {
        try {
            System.out.print("Digite o nome e sobrenome: ");
            String petName = SCANNER.nextLine();
            PetService.validatePetName(petName);

            System.out.print("Digite o tipo do pet [Cachorro/Gato]: ");
            String petTypeString = SCANNER.nextLine();
            PetType petType = PetService.validatePetType(petTypeString);

            System.out.print("Digite o sexo do pet [M/F]: ");
            String petSexString = String.valueOf(SCANNER.nextLine().charAt(0));
            PetSex petSex = PetService.validatePetSex(petSexString);

            System.out.println("Informações sobre o endereço.");
            System.out.print("Digite o número da casa: ");
            String houseNumber = SCANNER.nextLine();
            System.out.print("Digite o nome da cidade: ");
            String cityName = SCANNER.nextLine();
            System.out.print("Digite o nome da rua: ");
            String streetName = SCANNER.nextLine();
            Address petAddress = PetService.createAddress(houseNumber, cityName, streetName);

            System.out.print("Digite a idade do pet: ");
            String petAge = SCANNER.nextLine();
            petAge = PetService.validatePetAge(petAge);

            System.out.print("Digite o peso do pet: ");
            String petWeight = SCANNER.nextLine();
            petWeight = PetService.validatePetWeight(petWeight);

            System.out.print("Digite a raça do pet: ");
            String petRace = SCANNER.nextLine();
            PetService.validatePetRace(petRace);

            Pet pet = new Pet(petName, petType, petSex, petAddress, petAge, petWeight, petRace);
            System.out.println(pet);

            // TODO: Salvar informações do pet em arquivo
        } catch (InvalidPetException | NumberFormatException e) {
            System.out.println("Pet inválido: " + e.getMessage());
        }
    }

}
