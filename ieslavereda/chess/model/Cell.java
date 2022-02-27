package es.ieslavereda.chess.model;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Cell {
    private Coordinate coordinate;
    private CellColor color;
    private CellColor originalColor;
    private Piece piece;
    private Board board;

    public Cell(Board board, Coordinate coordinate){
        this.board = board;
        this.coordinate = coordinate;
        if(((coordinate.getLetter()-'A')+coordinate.getNumber())%2==0)
            originalColor=CellColor.BLACK_CELL;
        else
            originalColor=CellColor.WHITE_CELL;

        color = originalColor;
    }

    public String toString(){
        Attribute[] myFormat = new Attribute[]{color.getAttribute()};
        if(piece!=null)
            return piece.toString();
        else
            return colorize("   ",myFormat);
    }

    public Board getBoard() {
        return board;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public CellColor getColor() {
        return color;
    }

    /**
     * enumerador para poner color a las celdas
     */
    public enum CellColor{

        WHITE_CELL(Attribute.BACK_COLOR(180,180,180)),
        BLACK_CELL(Attribute.BACK_COLOR(100,100,100)),
        HIGHTLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180,0,0)),
        HIGHTLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130,0,0)),
        HIGHTLIGHT_WHITE(Attribute.BACK_COLOR(180,180,0)),
        HIGHTLIGHT_BLACK(Attribute.BACK_COLOR(130,130,0));

        private Attribute color;
        CellColor(Attribute color){
            this.color=color;
        }
        public Attribute getAttribute(){
            return color;
        }

        public Attribute getColor() {
            return color;
        }
    }

    /**
     * metodo para saber que color poner a las celdas que hay que resaltar
     */
    public void ColorM(){
        if(piece!=null){
            if (originalColor==CellColor.WHITE_CELL){
                color = CellColor.HIGHTLIGHT_KILL_WHITE;
            }else{
                color = CellColor.HIGHTLIGHT_KILL_BLACK;
            }
        }else{
            if (originalColor==CellColor.WHITE_CELL){
                color = CellColor.HIGHTLIGHT_WHITE;
            }else{
                color = CellColor.HIGHTLIGHT_BLACK;
            }

        }
    }

    /**
     * metodo que llama al color original de la celda
     */
    public void reset(){
        color=originalColor;
    }
}
