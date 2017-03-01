package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;

/**
 * Created by lmarcich on 3/1/17.
 */
public class Main {
    public static void main(String[] args) {
        new Application(new PrintStream(System.out)).start();
    }
}
