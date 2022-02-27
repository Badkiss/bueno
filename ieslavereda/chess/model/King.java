package es.ieslavereda.chess.model;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    /**
     * metodo me movimiento del rey
     * @return
     */
    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements = new ArrayList<>();
        Coordinate position = cell.getCoordinate();
        Coordinate aux = position.down();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }
        aux = position.up();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }
        aux = position.left();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }
        aux = position.right();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }
        aux = position.left().up();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }
        aux = position.right().up();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }
        aux = position.right().down();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }
        aux = position.left().down();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }
        return nextMovements;
    }
}
