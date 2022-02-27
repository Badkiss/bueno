package es.ieslavereda.chess.model;

import static es.ieslavereda.chess.model.ChessType.BLACK_ROOK;

public class BlackTower extends Tower{
    public BlackTower(Cell cell) {
        super(cell, BLACK_ROOK);
        place();
    }
}


