package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;


public class Application {
    private PrintStream printStream;
    private Library library;
    private Menu menu;

    public Application(PrintStream printStream, Library library, Menu menu) {
        this.printStream = printStream;
        this.library = library;
        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca!");
        menu.initiate();
    }
}
