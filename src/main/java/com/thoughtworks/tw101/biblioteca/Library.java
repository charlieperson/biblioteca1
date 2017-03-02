package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lmarcich on 3/2/17.
 */
public class Library {

    private PrintStream printStream;
    private ArrayList<Book> books;

    public Library(PrintStream printStream, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void listBooks() {
        String bookList = "";
        for(Book book : books){
            bookList += book.stringSummary() + "\n";
        }
        printStream.println(bookList);
    }


}
