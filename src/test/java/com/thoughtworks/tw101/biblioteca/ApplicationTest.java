package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private PrintStream printStream;
    private Library library;
    private Menu menu;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        menu = mock(Menu.class);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenAppStarts() throws IOException {
        Application application = new Application(printStream, menu);
        application.start();

        verify(printStream).println("Welcome to Biblioteca!");
    }



}