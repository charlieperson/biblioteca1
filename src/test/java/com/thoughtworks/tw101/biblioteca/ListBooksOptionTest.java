package com.thoughtworks.tw101.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by cperson on 3/6/17.
 */
public class ListBooksOptionTest {
    @Test
    public void shouldListBooksWhenExecuting() {
        Library library = mock(Library.class);
        ListBooksOption listBooksOption = new ListBooksOption(library);

        listBooksOption.execute();

        verify(library).listCheckedInBooks();
    }
}