package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by lmarcich on 3/2/17.
 */
public class Library {

    private PrintStream printStream;
    private List<Book> checkedIn;
    private List<Book> checkedOut;

    public Library(PrintStream printStream, List<Book> checkedIn, List<Book> checkedOut) {
        this.printStream = printStream;
        this.checkedIn = checkedIn;
        this.checkedOut = checkedOut;
    }

    public void listCheckedInBooks() {
        if(checkedIn.isEmpty()) printStream.println("Library contains no books");
        String bookList = "";
        int bookNum = 1;
        for(Book book : checkedIn){
            bookList += bookNum + ": " + book.stringSummary() + "\n";
            bookNum += 1;
        }
        printStream.println(bookList);
    }


    public void checkOut(String bookNum) {
        int desiredIndex = (Integer.parseInt(bookNum) - 1);
        Book book = checkedIn.remove(desiredIndex);
        checkedOut.add(book);
        printStream.println("Thank you! Enjoy the book: " + book.stringSummary());
    }
}
