package org.aikidistas.puzzle.userinteraction;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OutputHandlerTest {

    @Test
    void displayMessage() {
    }


    @Test
    void displayMessageToUser() {
        // GIVEN
        StringWriter output = new StringWriter();
        OutputHandler outputHandler = new OutputHandler(new PrintWriter(output));
        String expectedDisplayedText = "Some message to the user...";

        // WHEN
        outputHandler.displayMessage(expectedDisplayedText);

        // THEN
        assertThat(output.toString(), containsString(expectedDisplayedText));

    }
}