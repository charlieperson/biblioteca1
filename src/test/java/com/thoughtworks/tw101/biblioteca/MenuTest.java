package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**ß
 * Created by cperson on 3/2/17.
 */
public class MenuTest {

    private Library library;
    private PrintStream out;

    @Before
    public void setUp() {
        library = mock(Library.class);
        out = mock(PrintStream.class);
    }

    @Test
    public void shouldDisplayMenuPromptWhenInitiated(){
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream("not important".getBytes());
        System.setIn(mockInputStream);
        Menu menu = new Menu(out, library, System.in);
        menu.initiate();
        verify(out).println(contains("Options:"));
    }

    @Test
    public void shouldListBooksWhenUserChoosesOption1(){
        String userInput = "1";
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(mockInputStream);
        Menu menu = new Menu(out, library, System.in);
        menu.initiate();
        verify(library).listBooks();
    }

    @Test
    public void shouldReportInvalidInputWhenUserInputIsInvalid(){
        String userInput = "bad";
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(mockInputStream);
        Menu menu = new Menu(out, library, System.in);
        menu.initiate();
        verify(out).println(startsWith("Select"));
    }

}