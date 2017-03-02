package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.contains;


/**
 * Created by lmarcich on 3/1/17.
 */
public class ApplicationTest {

    private PrintStream printStream;
    private ArrayList<Book> books;
    private Library library;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        library = mock(Library.class);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenAppStarts(){
        Application application = new Application(printStream, new ArrayList<Book>(), library);
        application.start();

        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldCallListBooksWhenAppStarts(){
        Application application = new Application(printStream, new ArrayList<Book>(), library);
        application.start();
        verify(library).listBooks();
    }



}