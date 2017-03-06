package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


        ArrayList<Book> checkedIn = new ArrayList<>();
        ArrayList<Book> checkedOut = new ArrayList<>();
        checkedIn.add(new Book("whatever", "1996", "hello"));
        checkedIn.add(new Book("Who are you", "1965", "Who"));
        checkedOut.add(new Book("checked OUT!", "1996", "hello"));
        Library library = new Library(System.out, checkedIn, checkedOut);


        Map<String, Option> choiceToOption = new HashMap<>();
        choiceToOption.put("1", new ListBooksOption(library));
        choiceToOption.put("2", new CheckoutBookOption(System.out, library, new BufferedReader(new InputStreamReader(System.in))));


        Menu menu = new Menu(System.out, new BufferedReader(new InputStreamReader(System.in)), choiceToOption);
        Application application = new Application(System.out, menu);
        application.start();
    }
}
