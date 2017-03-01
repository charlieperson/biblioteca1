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

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenAppStarts(){
        Application application = new Application(printStream, new ArrayList<String>());
        application.start();

        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldPrintOneBookWhenListBooksIsCalledWithOneBookInTheLibrary(){
        ArrayList<String> books = new ArrayList<String>();
        books.add("Book1");
        Application application = new Application(printStream, books);
        application.listBooks();

        verify(printStream).println(contains("Book1"));

    }

    @Test
    public void shouldPrintTwoBooksWhenListBooksIsCalledWithTwoBooksInTheLibrary(){
        ArrayList<String> books = new ArrayList<String>();
        books.add("Book1");
        books.add("Book2");
        Application application = new Application(printStream, books);
        application.listBooks();

        for(String book : books){
            verify(printStream).println(contains(book));
        }
    }
}