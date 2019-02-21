package org.aikidistas.puzzle.userinteraction;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
    private OutputHandler output;

    private static final String INVALID_INPUT_MESSAGE = "Invalid option was entered.";

    public InputHandler(Scanner input, OutputHandler output) {
        this.scanner = input;
        this.output = output;
    }

    public String getUserChoice(String question, List<String> availableAnswers) {
        String displayedMessage = getDisplayedMessage(question, availableAnswers);

        String input = getInput(displayedMessage);

        while (!availableAnswers.contains(input)) {
            showValidationError();
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

    private void showValidationError() {
        output.displayMessage(INVALID_INPUT_MESSAGE);
    }

    private String getInput(String message) {
        output.displayMessage(message);
        return scanner.nextLine();
    }


}
