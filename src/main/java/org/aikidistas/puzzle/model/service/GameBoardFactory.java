package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.GameBoard;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

public class GameBoardFactory {

    public GameBoard createSolvedBoard() {
        int[][] solvedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };

        return GameBoard.createFrom2DArray(solvedBoard);
    }
}
