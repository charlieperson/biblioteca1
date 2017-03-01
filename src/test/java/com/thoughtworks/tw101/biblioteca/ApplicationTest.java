package com.thoughtworks.tw101.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by lmarcich on 3/1/17.
 */
public class ApplicationTest {

    @Test
    public void shouldPrintWelcomeMessageWhenAppStarts(){
        PrintStream printStream = mock(PrintStream.class);
        new Application(printStream).start();

        verify(printStream).println("Welcome to Biblioteca!");
    }

}