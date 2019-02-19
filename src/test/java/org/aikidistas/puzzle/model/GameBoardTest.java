package org.aikidistas.puzzle.model;

import org.junit.jupiter.api.Test;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameBoardTest {
    @Test
    void createFromTwoDimentionalIntArray() {
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };

        GameBoard board = GameBoard.createFrom2DArray(expectedBoard);

        assertEquals(expectedBoard, board.getBoard());

    }
}