package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Book> checkedIn = new ArrayList<>();
        ArrayList<Book> checkedOut = new ArrayList<>();
        checkedIn.add(new Book("whatever", "1996", "hello"));
        checkedOut.add(new Book("checked OUT!", "1996", "hello"));
        Library library = new Library(System.out, checkedIn, checkedOut);
        Menu menu = new Menu(System.out, library, new BufferedReader(new InputStreamReader(System.in)));
        Application application = new Application(System.out, menu);
        application.start();
    }
}
