package com.thoughtworks.tw101.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lmarcich on 3/2/17.
 */
public class BookTest {

    @Test
    public void shouldIncludeTitleInStringSummary(){
        Book book = new Book("The Pragmatic Programmer", "2000", "Uncle Bob");
        assert(book.stringSummary().contains("The Pragmatic Programmer"));
    }

    @Test
    public void shouldIncludeAuthorInStringSummary(){
        Book book = new Book("The Biology of Desire", "2008", "Mark Lewis");
        assert(book.stringSummary().contains("Mark Lewis"));
    }


    @Test
    public void shouldIncludeYearPublishedInStringSummary(){
        Book book = new Book("Huckleberry Finn", "1920", "Mark Twain");
        assert(book.stringSummary().contains("1920"));
    }

}