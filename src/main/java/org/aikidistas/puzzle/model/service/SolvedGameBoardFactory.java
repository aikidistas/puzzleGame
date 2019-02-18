package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Cell;
import org.aikidistas.puzzle.model.GameBoard;

import static org.aikidistas.puzzle.model.GameBoard.BORDER_SIZE;

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
        board = new Cell[BORDER_SIZE][BORDER_SIZE];
        numberOfInitializedCells = 0;
    }

    private void createSeriallyNumberedCellsInBoard() {
        for (int rowNumber = 0; rowNumber < BORDER_SIZE; rowNumber++) {
            initializeNumberedBoardRow(rowNumber);
        }
    }

    private void initializeNumberedBoardRow(int rowNumber) {
        for (int columnNumber = 0; columnNumber < BORDER_SIZE; columnNumber++) {
            initializeCell(rowNumber, columnNumber);
        }
    }

    private void initializeCell(int rowNumber, int columnNumber) {
        numberOfInitializedCells++;
        board[rowNumber][columnNumber] = Cell.fromValueAndCoordinates(numberOfInitializedCells, rowNumber, columnNumber);
    }

    private void makeLastCellEmpty() {
        board[BORDER_SIZE - 1][BORDER_SIZE - 1].setValue(Cell.EMPTY_VALUE);
    }
}
