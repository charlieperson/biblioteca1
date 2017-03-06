package com.thoughtworks.tw101.biblioteca;

/**
 * Created by cperson on 3/6/17.
 */
public class ListBooksOption implements Option {
    private Library library;

    public ListBooksOption(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.listCheckedInBooks();
    }
}
