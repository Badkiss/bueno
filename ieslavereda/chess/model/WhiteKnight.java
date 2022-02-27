package es.ieslavereda.chess.model;

import static es.ieslavereda.chess.model.ChessType.WHITE_KNIGHT;

public class WhiteKnight extends Knight{
    public WhiteKnight(Cell cell) {
        super(cell, WHITE_KNIGHT);
        place();
    }
}
