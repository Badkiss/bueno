package es.ieslavereda.chess.model;
import static es.ieslavereda.chess.model.ChessType.WHITE_ROOK;
public class WhiteTower extends Tower{
    public WhiteTower(Cell cell) {
        super(cell, WHITE_ROOK);
        place();
    }
}
