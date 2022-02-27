package es.ieslavereda.chess.model;

import static es.ieslavereda.chess.model.ChessType.BLACK_BISHOP;

public class BlackBishop extends Bishop{
    public BlackBishop(Cell cell) {
        super(cell, BLACK_BISHOP);
        place();
    }
}
