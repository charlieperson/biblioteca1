package com.thoughtworks.tw101.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("whatever", "1996", "hello"));
        Library library = new Library(System.out, books);
        Menu menu = new Menu(System.out, library, System.in);
        Application application = new Application(System.out, library, menu);
        application.start();
    }
}
