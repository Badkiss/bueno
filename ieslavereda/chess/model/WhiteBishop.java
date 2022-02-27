package es.ieslavereda.chess.model;
import static es.ieslavereda.chess.model.ChessType.WHITE_BISHOP;
public class WhiteBishop extends Bishop{
    public WhiteBishop(Cell cell) {
        super(cell, WHITE_BISHOP);
        place();
    }
}
