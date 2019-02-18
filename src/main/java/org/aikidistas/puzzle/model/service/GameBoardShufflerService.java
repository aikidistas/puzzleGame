package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Action;
import org.aikidistas.puzzle.model.GameBoard;

public class GameBoardShufflerService {

    private static final int NUMBER_OF_RANDOM_MOVES = 200;

    public GameBoard shuffle(GameBoard gameBoard) {
        for (int i = 0; i < NUMBER_OF_RANDOM_MOVES; i++) {
            gameBoard = applyRandomMove(gameBoard);
        }
        return gameBoard;
    }

    private GameBoard applyRandomMove(GameBoard gameBoard) {
        return Action.getRandomMove().applyTo(gameBoard);
    }
}
