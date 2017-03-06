package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private PrintStream out;
    private BufferedReader in;
    private Map<String, Option> choiceToOption;

    public Menu(PrintStream out, BufferedReader in, Map<String, Option> choiceToOption) {
        this.out = out;
        this.in = in;
        this.choiceToOption = choiceToOption;
    }

    public void chooseOption() throws IOException {
        printOptions();
        String choice;

        do {
            choice = in.readLine();
            if (choiceToOption.containsKey(choice)){
                Option option = choiceToOption.get(choice);
                option.execute();
            } else {
                switch (choice) {
                    case "Quit":
                        break;

                    default:
                        out.println("Select a valid option!");
                        break;
                }
            }
        } while (!choice.equals("Quit"));
    }

    private void printOptions() {
        out.println("Options:");
        out.println("1 - List books");
        out.println("2 - check out book");
        out.println("Quit - Quits the application");
    }
}
