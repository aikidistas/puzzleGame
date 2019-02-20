package org.aikidistas.puzzle.userinteraction;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.aikidistas.puzzle.userinteraction.OutputHandler.LINE_SEPARATOR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("squid:S00100")
class InputHandlerTest {


    @Test
    void getUserChoice_acceptsEmptyString_asNewLineAnswer() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = LINE_SEPARATOR;
        InputHandler inputHandler = new InputHandler(new Scanner(input), new OutputHandler(new PrintWriter(output)));
        String questionText = "Please click enter keyboard button...";
        String expectedAnswer = "";
        List<String> availableAnswers = Collections.singletonList(expectedAnswer);

        // WHEN
        String result = inputHandler.getUserChoice(questionText, availableAnswers);

        // THEN
        assertEquals(expectedAnswer, result);
    }

    @Test
    void showsMessage() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = LINE_SEPARATOR;
        InputHandler inputHandler = new InputHandler(new Scanner(input), new OutputHandler(new PrintWriter(output)));
        String questionText = "Please click enter keyboard button...";
        String expectedAnswer = "";
        List<String> availableAnswers = Collections.singletonList(expectedAnswer);

        // WHEN
        inputHandler.getUserChoice(questionText, availableAnswers);

        // THEN
        assertThat(output.toString(), containsString(questionText));
    }

    @Test
    void showsAvailableAnswers() {
        // GIVEN
        StringWriter output = new StringWriter();
        String input = "WRONG_ANSWER" + LINE_SEPARATOR
                + "B" + LINE_SEPARATOR;
        InputHandler inputHandler = new InputHandler(new Scanner(input), new OutputHandler(new PrintWriter(output)));
        String questionText = "This is a question...";
        List<String> availableAnswers = Arrays.asList("B", "C");

        // WHEN
        inputHandler.getUserChoice(questionText, availableAnswers);

        // THEN
        String expectedAnswersText = "(B, C)";
        assertThat(output.toString(), containsString(expectedAnswersText));
    }
}