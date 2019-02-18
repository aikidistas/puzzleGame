package org.aikidistas.puzzle.model.service;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.GameBoard;

@AllArgsConstructor
public class GameBoardService {
    GameBoardShufflerService shuffler;
    SolvedGameBoardFactory solvedGameBoardFactory;

    public GameBoard getSolvedGameBoard() {
        return solvedGameBoardFactory.create();
    }

    public GameBoard getShuffledGameBoard() {
        return shuffler.shuffle(getSolvedGameBoard());
    }
}
