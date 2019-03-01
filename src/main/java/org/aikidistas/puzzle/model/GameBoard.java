package org.aikidistas.puzzle.model;

import java.util.Arrays;

public class GameBoard {
    public static final int EMPTY_CELL = 0;


    private final int[][] board;
    private Coordinate emptyCell = new Coordinate(3, 3);

    GameBoard(int[][] board) {
        this.board = board;
    }

    GameBoard(int[][] board, Coordinate emptyCell) {
        this.board = board;
        this.emptyCell = emptyCell;
        this.board[emptyCell.getX()][emptyCell.getY()] = EMPTY_CELL;
    }

    private static int[][] copyOf(int[][] sourceBoard) {
        int rowsCount = sourceBoard.length;
        int[][] targetBoard = new int[rowsCount][];
        for (int i = 0; i < rowsCount; i++) {
            targetBoard[i] = Arrays.copyOf(sourceBoard[i], sourceBoard[i].length);
        }
        return targetBoard;
    }

    public int[][] getBoard() {
        return copyOf(board);
    }

    public void moveUp() {
        move(emptyCell.getNeighbourUp());
    }

    @SuppressWarnings("WeakerAccess")
    public void moveDown() {
        move(emptyCell.getNeighbourDown());
    }

    public void moveLeft() {
        move(emptyCell.getNeighbourLeft());
    }

    @SuppressWarnings("WeakerAccess")
    public void moveRight() {
        move(emptyCell.getNeighbourRight());
    }

    private void move(Coordinate targetCell) {
        if (isNotValidCoordinate(targetCell)) {
            return;
        }

        switchCellsContent(emptyCell, targetCell);
        emptyCell = targetCell;
    }

    private boolean isNotValidCoordinate(Coordinate targetCell) {
        if (isNotValidRow(targetCell)) {
            return true;
        }

        return isNotValidColumn(targetCell);

    }

    private boolean isNotValidRow(Coordinate targetCell) {
        return (targetCell.getX() < 0) || (targetCell.getX() >= board.length);
    }

    private boolean isNotValidColumn(Coordinate targetCell) {
        return (targetCell.getY() < 0) || (targetCell.getY() >= board[targetCell.getX()].length);
    }

    private void switchCellsContent(Coordinate coordinate, Coordinate coordinate2) {
        int x1 = coordinate.getX();
        int y1 = coordinate.getY();
        int x2 = coordinate2.getX();
        int y2 = coordinate2.getY();
        int valueBackup = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = valueBackup;
    }


}
