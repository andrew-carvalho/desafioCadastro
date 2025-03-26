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
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
