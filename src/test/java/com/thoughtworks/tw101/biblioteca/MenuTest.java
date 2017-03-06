package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**ß
 * Created by cperson on 3/2/17.
 */
public class MenuTest {


    private BufferedReader bufferedReader;
    private Library library;
    private PrintStream out;
    private HashMap<String, Option> choiceToOption;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        out = mock(PrintStream.class);
        choiceToOption = mock(HashMap.class);
    }

    @Test
    public void shouldDisplayMenuPromptWhenInitiated() throws IOException {
        when(bufferedReader.readLine()).thenReturn("not important", "Quit");
        Menu menu = new Menu(out, bufferedReader, choiceToOption);
        menu.chooseOption();
        verify(out).println(contains("Options:"));
    }

    @Test
    public void shouldReportInvalidInputWhenUserInputIsInvalid() throws IOException {
        when(bufferedReader.readLine()).thenReturn("bad", "Quit");
        Menu menu = new Menu(out, bufferedReader, choiceToOption);
        menu.chooseOption();
        verify(out).println(startsWith("Select"));
    }

    @Test
    public void shouldContinuouslyReceiveInputWhenQuitIsNotChoosen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("invalid", "bannana", "Quit");
        Menu menu = new Menu(out, bufferedReader, choiceToOption);
        menu.chooseOption();
        verify(out, times(2)).println(contains("Select"));
    }
}