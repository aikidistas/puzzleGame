package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.GameBoard;

import java.util.Arrays;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

public class GameBoardValidatorService {

    private static final int[][] solvedBoard = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, EMPTY_CELL}
    };

    public boolean isSolved(GameBoard gameBoard) {
        return Arrays.deepEquals(gameBoard.getBoard(), solvedBoard);
    }
}
