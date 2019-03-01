package org.aikidistas.puzzle.model;

public class CustomGameBoardFactory {

    public GameBoard createFrom2DArrayAndEmptyCellCoordinate(int[][] newBoard, Coordinate emptyCell) {
        return new GameBoard(newBoard, emptyCell);
    }
}
