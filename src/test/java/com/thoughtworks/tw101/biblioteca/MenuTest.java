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
        when(bufferedReader.readLine()).thenReturn("not important");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(out).println(contains("Options:"));
    }

    @Test
    public void shouldListBooksWhenUserChoosesOption1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(library).listBooks();
    }

    @Test
    public void shouldReportInvalidInputWhenUserInputIsInvalid() throws IOException {
        when(bufferedReader.readLine()).thenReturn("bad");
        Menu menu = new Menu(out, library, bufferedReader);
        menu.chooseOption();
        verify(out).println(startsWith("Select"));
    }

//    @Test
//    public void shouldPromptUserForInputAfterInvalidInput() {
//        String userInput = "bad";
//        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(mockInputStream);
//
//        Menu menu = new Menu(out, library,System.in);
//        menu.chooseOption();
//        verify(menu, times(2)).chooseOption();
//    }

//    @Test
//    public void shouldExitProgramWhenUserChoosesQuitOption(){
//        String userInput = "0";
//        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(mockInputStream);
//
//        Menu menu = new Menu(out, library, System.in);
//        assertEquals(null, menu.chooseOption());
//    }
}