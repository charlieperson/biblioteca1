package com.thoughtworks.tw101.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cperson on 3/6/17.
 */
public class CheckoutBookOptionTest {
    @Test
    public void shouldCheckOutBookWhenExecuting() throws IOException {
        Library library = mock(Library.class);
        PrintStream out = mock(PrintStream.class);
        BufferedReader in = mock(BufferedReader.class);
        when(in.readLine()).thenReturn("1");
        CheckoutBookOption checkoutBookOption = new CheckoutBookOption(out, library, in);
        checkoutBookOption.execute();
        verify(library).checkOut("1");
        verify(out).println(contains("Which book"));
    }

}