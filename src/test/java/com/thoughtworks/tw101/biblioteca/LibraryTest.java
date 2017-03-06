package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    private PrintStream printStream;
    private List<Book> checkedIn;
    private List<Book> checkedOut;

    @Before
    public void setUp() {

        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        when(book1.stringSummary()).thenReturn("Book1");
        when(book2.stringSummary()).thenReturn("Book2");
        checkedIn = new ArrayList<>(Arrays.asList(book1, book2));
        checkedOut = new ArrayList<>();
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintAllCheckedInBooksWhenListingCheckedInBooks(){
        Library library = new Library(printStream, checkedIn, checkedOut);
        library.listCheckedInBooks();
        verify(printStream).println(contains("Book1\nBook2"));
    }

    @Test
    public void shouldNotListBooksThatAreCheckedOutWhenListingCheckedInBooks() {
        Book checkedOutBook = mock(Book.class);
        when(checkedOutBook.stringSummary()).thenReturn("Book3");
        checkedOut.add(checkedOutBook);
        Library library = new Library(printStream, checkedIn, checkedOut);
        library.listCheckedInBooks();
        verify(printStream, never()).println(contains("3"));
    }

    @Test
    public void shouldRemoveBookFromCheckedInWhenItIsCheckedOut() {
        Book book3 = mock(Book.class);
        checkedIn.add(book3);
        Library library = new Library(printStream, checkedIn, checkedOut);
        library.checkOut("3");
        assertTrue(!checkedIn.contains(book3));
    }

    @Test
    public void shouldAddCheckedOutBookToCheckedOutBooks(){
        Book book3 = mock(Book.class);
        checkedIn.add(book3);
        Library library = new Library(printStream, checkedIn, checkedOut);
        library.checkOut("3");
        assertTrue(checkedOut.contains(book3));
    }

    @Test
    public void shouldTellUserThatThereAreNoBooks() {
        List<Book> emptyCheckedIn = new ArrayList<>();
        Library library = new Library(printStream, emptyCheckedIn, checkedOut);
        library.listCheckedInBooks();
        verify(printStream).println(contains("Library contains no books"));
    }

}