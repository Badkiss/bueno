 package es.ieslavereda.chess.model;

import es.ieslavereda.chess.model.dynamicStructure.Recolector;

import java.util.*;


 public class Board {

    private Map<Coordinate,Cell> cells;
    private IDeletedPieceManager store;
    private List<Piece> blancas;
     private List<Piece> negras;

    public Board(){
        cells = new  HashMap<Coordinate,Cell>();
        blancas= new LinkedList<Piece>();
        negras=new LinkedList<Piece>();
        store = new Recolector();
        for (int row=1;row<=8;row++){
            for (int col=0;col<8;col++){
               Coordinate c=new Coordinate((char)('A'+col),row);
               Cell cl=new Cell(this,c);
               cells.put(c,cl);
            }
        }

        placePieces();
    }

     /**
      * metodo para insertar las piezas en el tablero a partir de coordenadas
      */

    private void placePieces() {
        for(int i =0;i<8;i++) {
            blancas.add(new WhitePawn(getCellAt(new Coordinate((char) ('A'+i), 7))));
            negras.add(new BlackPawn(getCellAt(new Coordinate((char) ('A'+i), 2))));
        }
        blancas.add(new WhiteKing(getCellAt(new Coordinate('E',8))));
        blancas.add(new WhiteTower(getCellAt(new Coordinate('A',8))));
        blancas.add(new WhiteTower(getCellAt(new Coordinate('H',8))));
        blancas.add(new WhiteKnight(getCellAt(new Coordinate('B',8))));
        blancas.add(new WhiteKnight(getCellAt(new Coordinate('G',8))));
        blancas.add(new WhiteBishop(getCellAt(new Coordinate('C',8))));
        blancas.add(new WhiteBishop(getCellAt(new Coordinate('F',8))));
        blancas.add(new WhiteQueen(getCellAt(new Coordinate('D',8))));

        negras.add(new BlackTower(getCellAt(new Coordinate('A',1))));
        negras.add(new BlackTower(getCellAt(new Coordinate('H',1))));
        negras.add(new BlackKnight(getCellAt(new Coordinate('B',1))));
        negras.add(new BlackKnight(getCellAt(new Coordinate('G',1))));
        negras.add(new BlackBishop(getCellAt(new Coordinate('C',1))));
        negras.add(new BlackBishop(getCellAt(new Coordinate('F',1))));
        negras.add(new BlackQueen(getCellAt(new Coordinate('D',1))));
        negras.add(new BlackKing(getCellAt(new Coordinate('E',1))));

    }

     public IDeletedPieceManager getStore() {
         return store;
     }

     /**
      * metodo para saber si una coordenada es valida o no
      * @param coordinate la coordenada
      * @return
      */
     public boolean containsCellAt(Coordinate coordinate){
        if(coordinate.getLetter()<'A'|| coordinate.getLetter()>'H')
            return false;
        if(coordinate.getNumber()<1 || coordinate.getNumber()>8)
            return false;

        return true;
    }

     /**
      * metodo para saber si en una coordenada hay una pieza
      * @param coordinate
      * @return
      */
    public boolean containsPieceAt(Coordinate coordinate){
        Cell cell = getCellAt(coordinate);
        if(cell == null) return false;
        return (cell.getPiece()!=null);
    }

     /**
      * metodo para conseguir la pieza a partir de una coordenada
      * @param coordinate
      * @return
      */
    public Cell getCellAt(Coordinate coordinate){
        return cells.get(coordinate);
        }
        public Collection<Cell> getAllCells(){
        return cells.values();
        }

     /**
      *metodo para cambiar el color del tablero
      * @param coordenadas
      */
    public void cambioColor(List<Coordinate> coordenadas){
        for(Coordinate coordenada:coordenadas){
            getCellAt(coordenada).ColorM();
        }
    }

     /**
      * metodo para dejar el tablero con el color predeterminado
      */
    public void restaurarTablero(){
        for (Cell filaC : cells.values()){
                filaC.reset();

        }
    }

     /**
      * metodo para mover las piezas
      * @param coordenadaa coordenada a la que se va a mover
      * @param coordenadab celda en la que se encuentra la pieza a mover
      * @return
      */
     public boolean moverP(Coordinate coordenadaa , Cell coordenadab){
       if (coordenadab.getPiece().mover(coordenadaa)){
           return true;
       }else {
           return false;
       }
     }
 }
