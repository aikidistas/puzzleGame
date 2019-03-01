package org.aikidistas.puzzle.model;

import org.aikidistas.puzzle.model.service.GameBoardService;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

public class ShuffledGameBoardFactory {
    private GameBoardService gameBoardService;

    public ShuffledGameBoardFactory(GameBoardService gameBoardService) {
        this.gameBoardService = gameBoardService;
    }

    private GameBoard createSolvedGameBoard() {
        return new GameBoard(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        });
    }

    public GameBoard createShuffledGameBoard() {
        GameBoard solvedGameBoard = createSolvedGameBoard();
        return gameBoardService.shuffle(solvedGameBoard);
    }
}
