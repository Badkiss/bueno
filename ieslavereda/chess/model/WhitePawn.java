package es.ieslavereda.chess.model;

import java.util.ArrayList;
import java.util.List;


public class WhitePawn extends Piece {
    public WhitePawn(Cell cell) {
        super(cell, ChessType.WHITE_PAWN);
        place();
    }

    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements=new ArrayList<>();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;
        if (position.getNumber() == 7) {
            aux = position.up();
            if (canMoveToPawn(aux)) {
                nextMovements.add(aux);
            }
            aux = position.up().up();
            if (canMoveToPawn(aux)) {
                nextMovements.add(aux);
            }
            aux=position.up().right();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }
            aux=position.up().left();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }

        }else{
            aux=position.up();
            if (canMoveToPawn(aux)){
                nextMovements.add(aux);
            }
            aux=position.up().right();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }
            aux=position.up().left();
            if (canMoveToPawnKill(aux)){
                nextMovements.add(aux);

            }
        }
        return nextMovements;
    }
    @Override
    public boolean mover(Coordinate coordenada){
        Board tablero = cell.getBoard();
       boolean fin =super.mover(coordenada);
        if (coordenada.getNumber()==1){
            tablero.getStore().add(this);
            cell.setPiece(null);
            cell.setPiece(new WhiteQueen(cell));
        }
            return fin;

    }

}