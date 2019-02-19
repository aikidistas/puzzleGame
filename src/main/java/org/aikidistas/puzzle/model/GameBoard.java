package org.aikidistas.puzzle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@EqualsAndHashCode
@ToString
public class GameBoard {
    public static final int BORDER_SIZE = 4;
    public static final int EMPTY_CELL = 0;
    private static final int[][] solvedBoard = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, EMPTY_CELL}
    };
    private final int[][] board;

    private GameBoard(int[][] board) {
        this.board = board;
    }

    public static GameBoard createFrom2DArray(int[][] board) {
        return new GameBoard(board);
    }

    public void switchCells(Coordinate coordinate, Coordinate coordinate2) {
        // TODO: add error handling for invalid coordinates
        int x1 = coordinate.getX();
        int y1 = coordinate.getY();
        int x2 = coordinate2.getX();
        int y2 = coordinate2.getY();
        int valueBackup = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = valueBackup;


    }

    public boolean isSolved() {
        return Arrays.deepEquals(board, solvedBoard);
    }
}
