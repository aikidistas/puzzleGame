package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Action;
import org.aikidistas.puzzle.model.GameBoard;

public class GameBoardModifierService {
    private static final int NUMBER_OF_RANDOM_MOVES = 200;

    public GameBoard shuffle(GameBoard gameBoard) {
        for (int i = 0; i < NUMBER_OF_RANDOM_MOVES; i++) {
            applyRandomMove(gameBoard);
        }
        return gameBoard;
    }

    private void applyRandomMove(GameBoard gameBoard) {
        Action.getRandomMove().applyTo(gameBoard);
    }
}
