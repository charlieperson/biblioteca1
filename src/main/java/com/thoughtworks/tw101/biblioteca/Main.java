package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lmarcich on 3/1/17.
 */
public class Main {
    public static void main(String[] args) {
        Application application = new Application(System.out, new ArrayList<Book>(), new Library(System.out, new ArrayList<Book>()));
        application.start();
    }
}
