package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by cperson on 3/6/17.
 */
public class CheckoutBookOption implements Option {

    private PrintStream out;
    private Library library;
    private BufferedReader in;

    public CheckoutBookOption(PrintStream out, Library library, BufferedReader in) {
        this.out = out;
        this.library = library;
        this.in = in;

    }

    @Override
    public void execute() throws IOException {
        out.println("Which book would you like to check out?");
        library.listCheckedInBooks();
        String bookNumber = in.readLine();
        library.checkOut(bookNumber);
    }
}
