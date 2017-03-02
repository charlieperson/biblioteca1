package com.thoughtworks.tw101.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by cperson on 3/2/17.
 */
public class Menu {
    private PrintStream out;
    private Library library;
    private Scanner scanner;

    public Menu(PrintStream out, Library library, InputStream inputStream) {
        this.out = out;
        this.library = library;
        this.scanner = new Scanner(inputStream);
    }

    public void initiate() {
        printOptions();

        String choice = scanner.nextLine();
        switch(choice) {
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
