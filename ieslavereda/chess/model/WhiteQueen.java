package es.ieslavereda.chess.model;
import static   es.ieslavereda.chess.model.ChessType.WHITE_QUEEN;
public class WhiteQueen extends Queen{
    public WhiteQueen(Cell cell) {
        super(cell, WHITE_QUEEN);
        place();
    }
}
