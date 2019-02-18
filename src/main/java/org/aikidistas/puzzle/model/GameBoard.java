package org.aikidistas.puzzle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GameBoard {
    public static final int BORDER_SIZE = 4;
    private Cell[][] board;
}
