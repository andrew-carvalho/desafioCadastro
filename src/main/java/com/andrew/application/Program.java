package com.andrew.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        printMenu();
    }

    public static void printMenu() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("formulario.txt"))) {
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro interno! " + e.getMessage());
        }
    }

}
