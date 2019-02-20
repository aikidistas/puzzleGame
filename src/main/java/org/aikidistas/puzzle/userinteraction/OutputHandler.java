package org.aikidistas.puzzle.userinteraction;

import java.io.PrintWriter;

public class OutputHandler {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private PrintWriter output;

    public OutputHandler(PrintWriter output) {
        this.output = output;
    }

    public void displayMessage(String message) {
        output.println(message);
    }
}
