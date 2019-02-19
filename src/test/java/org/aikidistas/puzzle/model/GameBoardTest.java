package org.aikidistas.puzzle.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameBoardTest {
    @Test
    void fromTwoDimentionalIntArray() {
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, Coordinate.EMPTY_VALUE}
        };

        GameBoard board = new GameBoard();
        board.setBoard(expectedBoard);

        assertEquals(expectedBoard, board.getBoard());

    }
}