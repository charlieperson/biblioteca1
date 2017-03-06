package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**ß
 * Created by cperson on 3/2/17.
 */
public class MenuTest {

    private BufferedReader bufferedReader;
    private Library library;
    private PrintStream out;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        out = mock(PrintStream.class);
    }

    @Test
    public void shouldDisplayMenuPromptWhenInitiated() throws IOException {
        when(bufferedReader.readLine()).thenReturn("not important", "0");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(out).println(contains("Options:"));
    }

    @Test
    public void shouldListBooksWhenUserChoosesOption1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).listBooks();
    }

    @Test
    public void shouldReportInvalidInputWhenUserInputIsInvalid() throws IOException {
        when(bufferedReader.readLine()).thenReturn("bad", "0");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(out).println(startsWith("Select"));
    }

    @Test
    public void shouldContinuouslyReceiveInputWhenQuitIsNotChoosen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "bannana", "0");

        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).listBooks();
        verify(out).println(contains("Select"));
    }
}