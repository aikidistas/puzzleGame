package org.aikidistas.puzzle.userinteraction;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
    private OutputHandler output;

    public InputHandler(Scanner input, OutputHandler output) {
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

    // TODO: split available answers to answers model and formatter (in other class) Will be easier to test answers
    private String answersToText(List<String> availableAnswers) {
        return String.join(", ", availableAnswers);
    }

    private String getInput(String message) {
        output.displayMessage(message);
        return scanner.nextLine();
    }


}
