package es.ieslavereda.chess.model;

import java.util.ArrayList;
import java.util.List;

public class BlackPawn extends Piece{
    public BlackPawn(Cell cell) {
        super(cell, ChessType.BLACK_PAWN);
        place();
    }

    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements=new ArrayList<>();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;
        if (position.getNumber() == 2) {
            aux = position.down();
            if (canMoveToPawn(aux)) {
                nextMovements.add(aux);
            }
            aux = position.down().down();
            if (canMoveToPawn(aux)) {
                nextMovements.add(aux);
            }
            aux=position.down().right();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }
            aux=position.down().left();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }

        }else{
            aux=position.down();
            if (canMoveToPawn(aux)){
                nextMovements.add(aux);
            }
            aux=position.down().right();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }
            aux=position.down().left();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }
        }
        return nextMovements;
    }
    @Override
    public boolean mover(Coordinate coordenada){
        Board tablero = cell.getBoard();
        boolean fin= super.mover(coordenada);
        if (coordenada.getNumber()==8){
            tablero.getStore().add(this);
            cell.setPiece(null);
            cell.setPiece(new BlackQueen(cell));
        }
        return fin;

    }
}
