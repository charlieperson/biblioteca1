package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;

/**
 * Created by lmarcich on 3/1/17.
 */
public class Application {
    private PrintStream printStream;

    public Application(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca!");
    }
}
