package org.aikidistas.puzzle;

import org.aikidistas.puzzle.controller.GameController;
import org.aikidistas.puzzle.model.service.GameBoardService;
import org.aikidistas.puzzle.model.service.GameBoardShufflerService;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.userinteraction.OutputHandler;
import org.aikidistas.puzzle.view.GameView;

import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("WeakerAccess")
public class ApplicationRunner {

    public static void main(String[] args) {
        GameController controller = initializeGameController();
        controller.start();
    }

    @SuppressWarnings("squid:S106")
    private static GameController initializeGameController() {
        OutputHandler outputHandler = new OutputHandler(new PrintWriter(System.out, true));
        return new GameController(
                new GameView(outputHandler),
                new InputHandler(new Scanner(System.in), outputHandler),
                new GameBoardService(new GameBoardShufflerService())
        );
    }
}
