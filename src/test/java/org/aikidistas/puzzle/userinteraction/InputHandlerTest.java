package org.aikidistas.puzzle.userinteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.aikidistas.puzzle.userinteraction.OutputHandler.LINE_SEPARATOR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("squid:S00100")
class InputHandlerTest {


    private String question;
    private List<String> availableAnswers;
    private String selectedAnswer;
    private String userInput;
    private InputHandler inputHandler;
    private StringWriter output;

    @BeforeEach
    void setUp() {
        output = new StringWriter();
        String defaultAvailableAnswer = "DEFAULT_AVAILABLE_ANSWER";

        givenQuestion("Default question");
        givenAvailableAnswers(defaultAvailableAnswer);
        givenUserWillAnswer(defaultAvailableAnswer);
    }

    @Test
    void getUserChoice_givenQuestionAndAvailableAnswers_willReturnOneUsersChosenAnswer() {
        String chosenAnswer = "CHOSEN_ANSWER";

        givenQuestion("Some question to the user");
        givenAvailableAnswers(chosenAnswer, "some other answer");
        givenUserWillAnswer(chosenAnswer);

        whenGetUserChoiceIsInvoked();

        thenSelectedAnswerEquals(chosenAnswer);
    }


    @Test
    void getUserChoice_showsQuestionToTheUser() {
        String question = "Some question to the user";
        givenQuestion(question);

        whenGetUserChoiceIsInvoked();

        thenOutputContains(question);
    }

    @Test
    void getUserChoice_showsAvailableAnswersToTheUser() {
        givenAvailableAnswers("FIRST_ANSWER", "SECOND_ANSWER");
        givenUserWillAnswer("FIRST_ANSWER");

        whenGetUserChoiceIsInvoked();

        thenOutputContains("(FIRST_ANSWER, SECOND_ANSWER)");
    }

    @Test
    void getUserChoice_afterInvalidUserInput_showsErrorMessageToTheUser() {
        String correctAnswer = "CORRECT_ANSWER";

        givenAvailableAnswers(correctAnswer, "SOME_OTHER_CORRECT_ANSWER");
        givenUserWillAnswer("WRONG_ANSWER", correctAnswer);

        whenGetUserChoiceIsInvoked();

        thenOutputContains("Invalid option was entered.");
    }

    @Test
    void getUserChoice_willAskUserAgainAndAgain_untilCorrectAnswerIsChosenByUser() {
        String correctAnswer = "CORRECT_ANSWER";

        givenAvailableAnswers(correctAnswer);
        givenUserWillAnswer("WRONG_ANSWER", "OTHER_WRONG_ANSWER", correctAnswer);

        whenGetUserChoiceIsInvoked();

        thenSelectedAnswerEquals(correctAnswer);
    }

    private void givenQuestion(String question) {
        this.question = question;
    }

    private void givenAvailableAnswers(String... answers) {
        this.availableAnswers = Arrays.asList(answers);
    }

    private void givenUserWillAnswer(String... answer) {
        userInput = String.join(LINE_SEPARATOR, answer) + LINE_SEPARATOR;
    }

    private void whenGetUserChoiceIsInvoked() {
        inputHandler = new InputHandler(new Scanner(userInput), new OutputHandler(new PrintWriter(output)));
        selectedAnswer = inputHandler.getUserChoice(question, availableAnswers);
    }

    private void thenOutputContains(String text) {
        assertThat(output.toString(), containsString(text));
    }

    private void thenSelectedAnswerEquals(String availableAnswer) {
        assertEquals(availableAnswer, selectedAnswer);
    }
}