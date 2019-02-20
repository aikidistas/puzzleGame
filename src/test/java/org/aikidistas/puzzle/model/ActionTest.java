package org.aikidistas.puzzle.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SuppressWarnings("squid:S00100")
class ActionTest {

    @Test
    void getAvailableActionsAsText() {
        // WHEN
        List<String> actualActionTexts = Action.getAvailableActionsAsText();

        // THEN
        List<String> expectedActionTexts = new ArrayList<>();
        expectedActionTexts.add("UP");
        expectedActionTexts.add("DOWN");
        expectedActionTexts.add("LEFT");
        expectedActionTexts.add("RIGHT");
        expectedActionTexts.add("QUIT");

        assertEquals(expectedActionTexts, actualActionTexts);
    }

    @Test
    void getRandomMove_returnsOnlyMoveActionsAndNotQuitAction() {
        for (int i = 0; i < 10; i++) {
            // WHEN
            Action randomMove = Action.getRandomMove();

            // THEN
            assertNotEquals(Action.QUIT, randomMove);
        }
    }
}