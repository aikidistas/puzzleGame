package org.aikidistas.puzzle.userinteraction;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InOutHandlerTest {


    @Test
    void getUserChoice_acceptsEmptyString_asNewLineAnswer() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = "\n";
        InOutHandler InOutHandler = new InOutHandler(new Scanner(input), new PrintWriter(output));
        String questionText = "Please click enter keyboard button...";
        String expectedAnswer = "";
        List<String> availableAnswers = Collections.singletonList(expectedAnswer);

        // WHEN
        String result = InOutHandler.getUserChoice(questionText, availableAnswers);

        // THEN
        assertEquals(expectedAnswer, result);
    }

    @Test
    void showsMessage() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = "\n";
        InOutHandler InOutHandler = new InOutHandler(new Scanner(input), new PrintWriter(output));
        String questionText = "Please click enter keyboard button...";
        String expectedAnswer = "";
        List<String> availableAnswers = Collections.singletonList(expectedAnswer);

        // WHEN
        InOutHandler.getUserChoice(questionText, availableAnswers);

        // THEN
        assertThat(output.toString(), containsString(questionText));
    }

    @Test
    void showsAvailableAnswers() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = "WRONG_ANSWER\n"
                + "B\n";
        InOutHandler InOutHandler = new InOutHandler(new Scanner(input), new PrintWriter(output));
        String questionText = "This is a question...";
        List<String> availableAnswers = Arrays.asList("B", "C");

        // WHEN
        InOutHandler.getUserChoice(questionText, availableAnswers);

        // THEN
        String expectedAnswersText = "(B, C)";
        assertThat(output.toString(), containsString(expectedAnswersText));
    }

    @Test
    void displayMessageToUser() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = "";
        InOutHandler InOutHandler = new InOutHandler(new Scanner(input), new PrintWriter(output));
        String expectedDisplayedText = "Some message to the user...";

        // WHEN
        InOutHandler.displayMessageToUser(expectedDisplayedText);

        // THEN
        assertThat(output.toString(), containsString(expectedDisplayedText));

    }
}