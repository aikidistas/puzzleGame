package org.aikidistas.puzzle.model.service;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.GameBoard;

@AllArgsConstructor
public class GameBoardService {
    GameBoardShufflerService shuffler;
    GameBoardFactory gameBoardFactory;

    public GameBoard getSolvedGameBoard() {
        return gameBoardFactory.createSolvedBoard();
    }

    public GameBoard getShuffledGameBoard() {
        return shuffler.shuffle(getSolvedGameBoard());
    }
}
