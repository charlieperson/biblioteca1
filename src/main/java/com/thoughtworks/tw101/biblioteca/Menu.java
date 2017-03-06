package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
    private PrintStream out;
    private Library library;
    private Scanner scanner;
    private BufferedReader bufferedReader;

    public Menu(PrintStream out, Library library, BufferedReader bufferedReader) {
        this.out = out;
        this.library = library;
        this.bufferedReader = bufferedReader;
    }

    public void chooseOption() throws IOException {
        printOptions();

        String choice = bufferedReader.readLine();
        switch(choice) {
            case "0":
                return;

            case "1":
                library.listBooks();
                break;

            default:
                out.println("Select a valid option!");
                break;
        }
    }

    private void printOptions() {
        out.println("Options:");
        out.println("1 - List books");
    }
}
