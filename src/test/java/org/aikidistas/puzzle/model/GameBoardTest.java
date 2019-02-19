package org.aikidistas.puzzle.model;

import org.junit.jupiter.api.Test;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    @Test
    void createFromTwoDimentionalIntArray() {
        // GIVEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, EMPTY_CELL},
                {13, 14, 15, 12}
        };

        // WHEN
        GameBoard board = GameBoard.createFrom2DArray(expectedBoard);

        // THEN
        assertEquals(expectedBoard, board.getBoard());
    }

    @Test
    void isSolved() {
        // GIVEN
        int[][] solvedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = GameBoard.createFrom2DArray(solvedBoard);

        // THEN
        assertTrue(board.isSolved());
    }

    @Test
    void switchCells() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = GameBoard.createFrom2DArray(originalBoard);

        // WHEN
        board.switchCells(new Coordinate(3, 3), new Coordinate(2, 3));

        // THEN
        int[][] expectedChangedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, EMPTY_CELL},
                {13, 14, 15, 12}
        };

        assertArrayEquals(expectedChangedBoard, board.getBoard());
    }
}