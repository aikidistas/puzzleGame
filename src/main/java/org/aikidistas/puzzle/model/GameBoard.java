package org.aikidistas.puzzle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class GameBoard {
    public static final int BORDER_SIZE = 4;
    private Cell[][] board;
}
