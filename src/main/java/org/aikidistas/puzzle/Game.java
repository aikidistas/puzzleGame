package org.aikidistas.puzzle;

import org.aikidistas.puzzle.userinteraction.InOutHandler;

import java.util.Collections;

class Game {

    private InOutHandler inOutHandler;

    Game(InOutHandler inOutHandler) {
        this.inOutHandler = inOutHandler;
    }

    void play() {
        // generate random game board
        // show game board
        // get command
        // execute command
        playGame();
    }

    private void playGame() {
        inOutHandler.displayMessageToUser("Hello world");
        inOutHandler.getUserChoice("Write q to quit", Collections.singletonList("q"));
    }
}
