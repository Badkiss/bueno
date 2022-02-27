package es.ieslavereda.chess.model;
import java.util.ArrayList;
import java.util.List;

import static es.ieslavereda.chess.model.Tower.getNextMovementsAsRook;
import static es.ieslavereda.chess.model.Bishop.getNextMovementsAsBishop;
public abstract class Queen extends Piece{
    public Queen(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    /**
     * guarda los movimientos de  la pieza reina en una lista
     * @return
     */
    @Override
    public List<Coordinate>  getNextMovements() {
        List<Coordinate> coordenadaFinal = new ArrayList();
        List<Coordinate> torre = getNextMovementsAsRook(this);
        List<Coordinate> alfil = getNextMovementsAsBishop(this);
        coordenadaFinal.addAll(torre);
        coordenadaFinal.addAll(alfil);
        return coordenadaFinal;
    }
}
