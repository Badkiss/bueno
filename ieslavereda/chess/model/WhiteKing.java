package es.ieslavereda.chess.model;

import static es.ieslavereda.chess.model.ChessType.WHITE_KING;
public class WhiteKing extends King{
    public WhiteKing(Cell cell ) {
        super(cell, WHITE_KING );
        place();
    }
}
