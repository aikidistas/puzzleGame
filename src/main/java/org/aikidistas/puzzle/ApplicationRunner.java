package org.aikidistas.puzzle;

import org.aikidistas.puzzle.userinteraction.InOutHandler;

import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        Game game = initializeGame();
        game.play();
    }

    @java.lang.SuppressWarnings("squid:S106")
    private static Game initializeGame() {
        Game game;
        game = new Game(
                new InOutHandler(
                        new Scanner(System.in),
                        new PrintWriter(System.out, true)
                )
        );
        return game;
    }
}
