package es.ieslavereda.chess.model;
import static es.ieslavereda.chess.model.ChessType.BLACK_KING;
public class BlackKing extends  King{
    public BlackKing(Cell cell) {
        super(cell, BLACK_KING );
        place();
    }
}
