package org.aikidistas.puzzle;

import org.aikidistas.puzzle.controller.GameController;
import org.aikidistas.puzzle.model.ShuffledGameBoardFactory;
import org.aikidistas.puzzle.model.service.GameBoardModifierService;
import org.aikidistas.puzzle.model.service.GameBoardValidatorService;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.userinteraction.OutputHandler;
import org.aikidistas.puzzle.view.GameView;

import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        GameController controller = initializeGameController();
        controller.start();
    }

    @SuppressWarnings("squid:S106")
    private static GameController initializeGameController() {
        OutputHandler outputHandler = new OutputHandler(new PrintWriter(System.out, true));
        return new GameController(
                new ShuffledGameBoardFactory(new GameBoardModifierService()).createShuffledGameBoard(),
                new GameView(outputHandler, new GameBoardValidatorService()),
                new InputHandler(new Scanner(System.in), outputHandler)
        );
    }
}
