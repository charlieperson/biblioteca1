package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lmarcich on 3/1/17.
 */
public class Application {
    private PrintStream printStream;
    private ArrayList<String> books;

    public Application(PrintStream printStream, ArrayList<String> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca!");
    }

    public void listBooks() {
        for(String book : books){
            printStream.println(book);
        }
    }
}
