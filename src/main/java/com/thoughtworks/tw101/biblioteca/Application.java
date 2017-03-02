package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lmarcich on 3/1/17.
 */
public class Application {
    private PrintStream printStream;
    private ArrayList<Book> books;
    private Library library;

    public Application(PrintStream printStream, ArrayList<Book> books, Library library) {
        this.printStream = printStream;
        this.books = books;
        this.library = library;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca!");
        library.listBooks();
    }
}
