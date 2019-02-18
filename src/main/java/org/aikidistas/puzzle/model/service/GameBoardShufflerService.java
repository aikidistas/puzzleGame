package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Action;
import org.aikidistas.puzzle.model.GameBoard;

public class GameBoardShufflerService {

    private static final int DEFAULT_NUMBER_OF_RANDOM_MOVES = 200;

    public GameBoard shuffle(GameBoard gameBoard) {
        for (int i = 0; i < DEFAULT_NUMBER_OF_RANDOM_MOVES; i++) {
            Action.getRandomMove().applyTo(gameBoard);
        }
        return gameBoard;
    }
}
