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
    void createSolvedGameBoard() {
        // GIVEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };

        // WHEN
        GameBoard board = GameBoard.createSolvedGameBoard();

        // THEN
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void createSolvedGameBoard_returnsNewInternalBoardStateEachTime() {
        // WHEN
        GameBoard board = GameBoard.createSolvedGameBoard();
        GameBoard board2 = GameBoard.createSolvedGameBoard();

        // THEN
        assertNotEquals(board, board2);
        assertNotEquals(board.getBoard(), board2.getBoard());
        assertNotEquals(board.getBoard()[0], board2.getBoard()[0]);
        assertNotEquals(board.getBoard()[1], board2.getBoard()[1]);
        assertNotEquals(board.getBoard()[2], board2.getBoard()[2]);
        assertNotEquals(board.getBoard()[3], board2.getBoard()[3]);
    }

    @Test
    void createShuffledGameBoard() {
        // WHEN
        GameBoard board = GameBoard.createShuffledGameBoard();

        // THEN
        assertFalse(board.isSolved());
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