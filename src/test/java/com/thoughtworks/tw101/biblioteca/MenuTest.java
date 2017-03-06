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
        when(bufferedReader.readLine()).thenReturn("not important", "Quit");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(out).println(contains("Options:"));
    }

    @Test
    public void shouldListBooksWhenUserChoosesOption1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "Quit");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).listCheckedInBooks();
    }

    @Test
    public void shouldReportInvalidInputWhenUserInputIsInvalid() throws IOException {
        when(bufferedReader.readLine()).thenReturn("bad", "Quit");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(out).println(startsWith("Select"));
    }

    @Test
    public void shouldContinuouslyReceiveInputWhenQuitIsNotChoosen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "bannana", "Quit");

        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).listCheckedInBooks();
        verify(out).println(contains("Select"));
    }

    @Test
    public void shouldAllowCustomerToCheckOutABook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "1", "Quit");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).checkOut("1");
    }

    @Test
    public void shouldAllowCustomerToCheckOutADifferentBook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "3", "Quit");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).checkOut("3");
    }


}