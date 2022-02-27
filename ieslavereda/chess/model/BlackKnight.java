package es.ieslavereda.chess.model;

import static es.ieslavereda.chess.model.ChessType.BLACK_KNIGHT;

public class BlackKnight extends Knight{
    public BlackKnight(Cell cell) {
        super(cell, BLACK_KNIGHT);
        place();
    }

}
