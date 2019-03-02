package org.aikidistas.puzzle.model;

import org.aikidistas.puzzle.model.service.GameBoardModifierService;
import org.aikidistas.puzzle.model.service.GameBoardValidatorService;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

public class ShuffledGameBoardFactory {
    private GameBoardModifierService gameBoardModifierService;
    private GameBoardValidatorService gameBoardValidatorService;

    public ShuffledGameBoardFactory(GameBoardModifierService gameBoardModifierService, GameBoardValidatorService gameBoardValidatorService) {
        this.gameBoardModifierService = gameBoardModifierService;
        this.gameBoardValidatorService = gameBoardValidatorService;
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
        GameBoard shuffledGameBoard = gameBoardModifierService.shuffle(solvedGameBoard);
        while (gameBoardValidatorService.isSolved(shuffledGameBoard)) {
            shuffledGameBoard = gameBoardModifierService.shuffle(shuffledGameBoard);
        }
        return shuffledGameBoard;
    }
}
