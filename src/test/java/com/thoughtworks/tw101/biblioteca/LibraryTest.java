package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lmarcich on 3/2/17.
 */
public class LibraryTest {


    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintOneBookWhenListBooksIsCalledWithOneBookInTheLibrary(){
        Book book1 = mock(Book.class);
        when(book1.stringSummary()).thenReturn("Book1");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        Library library = new Library(printStream, books);
        library.listBooks();
        verify(printStream).println(contains("Book1"));
    }

    @Test
    public void shouldPrintAllBooksWhenListBooksIsCalledWhenMultipleBooksInTheLibrary(){
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        when(book1.stringSummary()).thenReturn("Book1");
        when(book2.stringSummary()).thenReturn("Book2");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        Library library = new Library(printStream, books);
        library.listBooks();
        verify(printStream).println(contains("Book1\nBook2"));
    }
//
//
//    @Test
//    public void shouldIncludeYearPublishedWhenListBooksIsCalled(){
//        Book b1 = new Book("Book1", "1973", "Dr. Suess");
//        books.add(b1);
//        Application application = new Application(printStream, books, library);
//        application.listBooks();
//
//
//        verify(printStream).println(contains("1973"));
//    }
//
//
//
//    @Test
//    public void shouldIncludeAuthorWhenListBooksIsCalled(){
//        Book b1 = new Book("Book1", "1973", "Dr. Suess");
//        books.add(b1);
//        Application application = new Application(printStream, books, library);
//        application.listBooks();
//        verify(printStream).println(contains("Dr. Suess"));
//    }

}