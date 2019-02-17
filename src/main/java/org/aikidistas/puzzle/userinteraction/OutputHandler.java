package org.aikidistas.puzzle.userinteraction;

import java.io.PrintWriter;

public class OutputHandler {
    private PrintWriter output;

    public OutputHandler(PrintWriter output) {
        this.output = output;
    }

    public void displayMessage(String message) {
        output.println(message);
    }
}
