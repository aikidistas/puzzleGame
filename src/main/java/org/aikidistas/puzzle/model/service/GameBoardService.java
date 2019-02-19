package org.aikidistas.puzzle.model.service;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.GameBoard;

@AllArgsConstructor
public class GameBoardService {
    GameBoardShufflerService shuffler;

    public GameBoard getShuffledGameBoard() {
        return shuffler.shuffle(GameBoard.createSolvedGameBoard());
    }
}
