package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Cell;
import org.aikidistas.puzzle.model.GameBoard;

public class SolvedGameBoardFactory {

    private Cell[][] board;
    private int numberOfInitializedCells = 0;

    public GameBoard create() {
        createSolvedBoard();
        GameBoard gameBoard = new GameBoard();
        gameBoard.setBoard(board);
        return gameBoard;
    }

    private void createSolvedBoard() {
        cleanBoard();
        createSeriallyNumberedCellsInBoard();
        makeLastCellEmpty();
    }

    private void cleanBoard() {
        board = new Cell[GameBoard.BORDER_SIZE][GameBoard.BORDER_SIZE];
        numberOfInitializedCells = 0;
    }

    private void createSeriallyNumberedCellsInBoard() {
        for (int rowNumber = 0; rowNumber < GameBoard.BORDER_SIZE; rowNumber++) {
            initializeNumberedBoardRow(rowNumber);
        }
    }

    private void initializeNumberedBoardRow(int rowNumber) {
        for (int columnNumber = 0; columnNumber < GameBoard.BORDER_SIZE; columnNumber++) {
            initializeCell(rowNumber, columnNumber);
        }
    }

    private void initializeCell(int rowNumber, int columnNumber) {
        numberOfInitializedCells++;
        board[rowNumber][columnNumber] = Cell.fromValueAndCoordinates(numberOfInitializedCells, rowNumber, columnNumber);
    }

    private void makeLastCellEmpty() {
        board[GameBoard.BORDER_SIZE - 1][GameBoard.BORDER_SIZE - 1].setValue(Cell.EMPTY_VALUE);
    }
}
