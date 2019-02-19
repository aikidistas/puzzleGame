package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;

public class SolvedGameBoardFactory {

    public GameBoard create() {
        int[][] solvedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, Coordinate.EMPTY_VALUE}
        };

        GameBoard board = new GameBoard();
        board.setBoard(solvedBoard);
        return board;
    }
}
