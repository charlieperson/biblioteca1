package com.thoughtworks.tw101.biblioteca;

/**
 * Created by lmarcich on 3/2/17.
 */
public class Book {
    private final String title;
    private final String year;
    private final String author;


    public Book(String title, String year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String stringSummary() {
        return title + " - " + year + " - " + author;
    }
}
