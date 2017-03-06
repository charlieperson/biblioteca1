package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {
    private PrintStream out;
    private Library library;
    private BufferedReader bufferedReader;

    public Menu(PrintStream out, Library library, BufferedReader bufferedReader) {
        this.out = out;
        this.library = library;
        this.bufferedReader = bufferedReader;
    }

    public void chooseOption() throws IOException {
        printOptions();
        String choice;

        do {
            choice = bufferedReader.readLine();
            switch (choice) {
                case "Quit":
                    return;

                case "1":
                    library.listCheckedInBooks();
                    break;

                case "2":
                    out.println("Which book would you like to check out?");
                    library.listCheckedInBooks();
                    String bookNumber = bufferedReader.readLine();
                    library.checkOut(bookNumber);
                    break;

                default:
                    out.println("Select a valid option!");
                    break;
            }
        } while (!choice.equals("Quit"));
    }

    private void printOptions() {
        out.println("Options:");
        out.println("1 - List books");
        out.println("2 - check out book");
        out.println("Quit - Quits the application");
    }
}
