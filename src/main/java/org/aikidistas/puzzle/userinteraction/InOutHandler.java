package org.aikidistas.puzzle.userinteraction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class InOutHandler {
    private Scanner scanner;
    private PrintWriter output;

    public InOutHandler(Scanner input, PrintWriter output) {
        this.scanner = input;
        this.output = output;
    }

    public String getUserChoice(String question, List<String> availableAnswers) {
        String displayedMessage = getDisplayedMessage(question, availableAnswers);

        String input = getInput(displayedMessage);

        while (!availableAnswers.contains(input)) {
            input = getInput(displayedMessage);
        }

        return input;
    }

    private String getDisplayedMessage(String message, List<String> availableAnswers) {
        return message + " (" + answersToText(availableAnswers) + ")";
    }

    private String answersToText(List<String> availableAnswers) {
        return String.join(", ", availableAnswers);
    }

    private String getInput(String message) {
        output.println(message);
        return scanner.nextLine();
    }

    public void displayMessageToUser(String message) {
        output.println(message);
    }
}
