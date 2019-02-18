package org.aikidistas.puzzle.model;

import lombok.extern.log4j.Log4j2;
import org.aikidistas.puzzle.model.service.ActionDownService;
import org.aikidistas.puzzle.model.service.ActionLeftService;
import org.aikidistas.puzzle.model.service.ActionNoneService;
import org.aikidistas.puzzle.model.service.ActionRightService;
import org.aikidistas.puzzle.model.service.ActionService;
import org.aikidistas.puzzle.model.service.ActionUpService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Log4j2
public enum Action {
    UP(new ActionUpService()),
    DOWN(new ActionDownService()),
    LEFT(new ActionLeftService()),
    RIGHT(new ActionRightService()),
    QUIT(new ActionNoneService());

    protected ActionService actionService;

    Action(ActionService actionService) {
        this.actionService = actionService;
    }

    public GameBoard applyTo(GameBoard gameBoard) {
        return actionService.applyTo(gameBoard);
    }

    public static List<String> getAvailableActionsAsText() {
        return Arrays.stream(Action.values()).map(Enum::toString).collect(Collectors.toList());
    }

    public static Action getRandomMove() {
        int pick = new Random().nextInt(Action.values().length - 1);
        return Action.values()[pick];
    }


}
